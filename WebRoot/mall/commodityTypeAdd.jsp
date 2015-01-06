
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>指标管理</title>

<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/dhtmlxcommon.js"></script>
<script type="text/javascript" src="../js/dhtmlxtree.js"></script>
<script type="text/javascript" src="../js/dhtmlxmenu.js"></script>
<script src="../js/dhtmlxtree_ed.js"></script>
<link rel="stylesheet" type="text/css" href="../css/dhtmlxtree.css" />
<link rel="stylesheet" type="text/css"
	href="../css/MenuSkins/dhtmlxmenu_dhx_blue.css" />
</head>

<body>
	<script type="text/javascript">
		$(function() {
			//初始化menu---------------------------------------------------------////
			menu = new dhtmlXMenuObject("divTree");
			menu.setImagePath("../images/DhtxMenu/");
			menu.setIconsPath("../images/MenuIcon/");
			menu.renderAsContextMenu(true);
			menu.attachEvent("onClick", HandleMClk);

			menu.loadXML("../data/dhtmlxmenu.xml");

			//初始化tree----------------------------------------------------------////
			tree = new dhtmlXTreeObject("divTree", "100%", "100%", 0);
			tree.setImagePath("../images/DhtxTree/");
			tree.enableHighlighting(true);

			//绑定时间处理函数,注意一定要放在loadXML之前否则右键处理函数在ie下失效
			tree.enableContextMenu(menu);
			tree.setOnClickHandler(HandleTreeClk);
			tree.setOnEditHandler(m_func);
			tree.enableItemEditor(true);
			//var data = "<tree id = \"1\"><item id = \"2\" text=\"asd\"/></tree>";
			//tree.loadXML()
			tree.loadXML("commodityType_getTypeList.action");
			//tree.loadXML("mall/mallUser_mallRegister.action");
		    //tree.loadXML("../data/tree.xml");

		});
		

		//菜单事件处理函数----------------------------------------------------////

		var newId = -1;
		var newItem = new Array();
		var editItemId =  new Array();
		var editItemText = new Array();
		function HandleMClk(menuid, zoom) {
			// alert(tree.getParentId(tree.getSelectedItemId()));
			if (menuid == "muItem_ADD") {
				var parentId = tree.getSelectedItemId();
				var itemId = --newId;
				newItem.push(itemId);
				tree.insertNewItem(parentId, itemId, "新建结点", 0, 0, 0, 0,
						'SELECT');
			} else if (menuid == "muItem_DELETE") {
				tree.deleteItem(tree.getSelectedItemId(), true);
				
				//加入调用后台验证是否有商品或者子类别的方法
			} else if (menuid = "muItem_EDIT") {
				//如果id大于0说明是以前增加过的节点 ，这时就把id和它的text记录下来，等到保存时发送更新请求
				//id小于0时为新增
			//	alert(1234);
				var editId = tree.getSelectedItemId();
				editItemId.push(editId)
				editItemText.push(tree.getItemText(editId));
				tree.editItem(editId);
			} else if (menuid = "muItem_SEARCH") {
				//查看商品
				
			}  

		}
		function m_func(state, id, tree, value) {
			if ((state == 2) && (value == ""))
				return false;
			return true;
		}

		function abcd() {
			alert(tree.getSubItems("ktLab"));
		}

		//树事件处理函数------------------------------------------------------////
		function HandleTreeClk(sId, src) {
			//alert(sId);
			//alert(src);
			var sTxt = tree.getItemText(sId);
			var sTxt = tree.getItemText(src);
		}
		
		var modifyJsonStr  = "[";
		function saveModify() {
			tree.stopEdit();
			for (var  i = 0; i < editItemId.length; ++i) {
				var id = editItemId[i];
				var text  = tree.getItemText(id);
				var oldText = editItemText[i];
				if (text != oldText) {
					//证明是之前保存过并这次修改 了
					if (modifyJsonStr != "[") {
						modifyJsonStr += ",";
					 }
					modifyJsonStr += "{\"id\" : \"" + id + "\", \"name\" : \"" + text + "\"}";
				
				}
			}
			modifyJsonStr += "]";
			alert(modifyJsonStr);
			//如果字符串中不等于空，证明已经有修改的节点 了，需要请求后台保存修改
			if (modifyJsonStr != "[]") {
			 	var params = {
					modifyData : modifyJsonStr
				};
				$.ajax({
					type : "POST",
					url : "commodityType_modifyCommodityType.action",
					data : params,
					dataType : "text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
					success : function(json) {
						var obj = $.parseJSON(json); //使用这个方法解析json
						var state_value = obj.result; //result是和action中定义的result变量的get方法对应的
						alert(state_value);
					},
					error : function(json) {
						alert("json=" + json);
						return false;
					}
				});
			}
		}
		
		
		var subTreeData;
		function createTreeData() {
			tree.selectItem(-1, false, false);
			tree.stopEdit();
			findRootNode(getChildItemId(-1));
			treeData = "<tree id =\"0\">";
			//create(-1);
			//逐个加入子树
			for (var  i= 0; i < createRootNode.length; ++i) {
				subTreeData  = "<item id=\"" + createRootNode[i] + "\" text=\"" +  tree.getItemText(createRootNode[i]) + "\" ";
				if (tree.getParentId(createRootNode[i]) > 0) {
					subTreeData += "parentid=\"" +  tree.getParentId(createRootNode[i]) + "\"";
				}
				subTreeData += ">";
					create(createRootNode[i]);
				subTreeData += "</item>";
				treeData += subTreeData;
			}
			treeData += "</tree>";
			alert(treeData);
			return true;
		}

		var treeData;
		//头节点 
		var createRootNode= new Array();
		
		//找到新增的头节点 
		function findRootNode(childData) {
			for (var i = 0; i < childData.length; ++i) {
				var childId = childData[i];
				var parentId = tree.getParentId(childId);
		
				if ((childId < 0) && (parentId > 0 || parentId == -1)) {
					createRootNode.push(childId);
					//加入头节点 
				} else {
					//如果parentId大于0 说明 是之前保存过的,要继续往下找
					if (tree.getSubItems(childId) != "") {
						findRootNode(getChildItemId(childId));
					}
				}
			}
		}
		
		function getChildItemId(itemId) {
			var ids = new Array();
			if ((tree.getSubItems(itemId) + "").indexOf(",") >= 0) {
				ids =  tree.getSubItems(itemId).split(",");
			} else {
				ids.push(tree.getSubItems(itemId));
			}
			return ids;
		}
		
		
		function create(id) {
			if (tree.getSubItems(id) != "") {
				if ((tree.getSubItems(id) + "").indexOf(",") >= 0) {
					var subItems = tree.getSubItems(id).split(",");
					for (var i = 0; i < subItems.length; ++i) {
						var itemId = subItems[i];
						var itemText = tree.getItemText(itemId);
						subTreeData += "<item id=\"" + itemId + "\" text=\"" + itemText + "\">";
						create(itemId);
						subTreeData += "</item>";
					}
				} else {
					var itemId = tree.getSubItems(id);
					var itemText = tree.getItemText(itemId);
					subTreeData += "<item id=\"" + itemId + "\" text=\"" + itemText + "\">";
					create(itemId);
					subTreeData += "</item>";
				}
			}
		}
		

		function save() {
			if (tree.getSubItems(-1) == "") {
				return;
			}
			saveModify();
			saveTree();
		}
		
		
		//更新的组成JSON数组，用列表 就可以
		//新增的用树形结构
		function saveTree() {
			
			if (createTreeData()) {
				//alert(treeData);
				var params = {
					treeData : treeData
				};
				$.ajax({
					type : "POST",
					url : "commodityType_addCommodityType.action",
					data : params,
					dataType : "text", //ajax返回值设置为text（json格式也可用它返回，可打印出结果，也可设置成json）
					success : function(json) {
						var obj = $.parseJSON(json); //使用这个方法解析json
						var state_value = obj.result; //result是和action中定义的result变量的get方法对应的
						alert(state_value);
					},
					error : function(json) {
						alert("json=" + json);
						return false;
					}
				});

			}

			/*var requestStr = "[";
			for (var i = 0; i < newItem.length; ++i) {
				var itemId = newItem.pop();
				alert(itemId);
				var parentId = tree.getParentId(itemId);
				alert(parentId);
				var text = tree.getItemText(itemId);
				alert(text);
				var item = "{parentId:" + parentId + ", itemId:" + itemId
						+ ", text:'" + text + "'}";
				requestStr += item;
				if (i < newItem.length - 1) {
					requestStr += ",";
				}
			}
			requestStr += "]";
			alert(requestStr);*/

		}
	</script>
	<div id="divTree"
		style="width:200px;height:400px;border:1px solid #339966;"></div>
	<input type='button' onclick="save()">保存
	</input>
</body>
</html>
