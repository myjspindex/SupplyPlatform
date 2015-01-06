package com.supplyplatform.util;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;

import org.springframework.util.FileCopyUtils;

/**
 * �ļ�������  �ṩ�ļ�����������ת��
 * @author bxy
 *
 */
public class FileUtil {
	
	public static byte[] getFileBytes(File file) {
		if (file != null) {
			try {
				return FileCopyUtils.copyToByteArray(file);
			} catch (IOException z) {
				z.printStackTrace();
			}
		}
		return null;
	}
	
	public static Blob getFileBlob(byte[]  fileByte) {
		return null;
	}

	public static Blob getFileBlob(File file) {
		return getFileBlob(getFileBytes(file));
	}
	
}
