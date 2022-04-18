package com.raymon.workrecord.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.util.StringUtils;

/**
 * 文件下载工具类
 * @author HuangZhengQing
 * 2021-10-20 15:28
 */
public class FileUtils {
	
	private static final Logger log = LoggerFactory.getLogger(FileUtils.class);
	
	/**
	 * 下载文件（建立较长时间的连接，至到文件下载完成。）
	 * @param response 响应消息
	 * @param path 文件存放于服务器的绝对路径
	 * @param downloadFileName 下载后显示给用户的文件名称
	 * @return
	 */
	public static HttpServletResponse downloadFile(HttpServletResponse response, String path, String downloadFileName) {
		try {
			if(!StringUtils.isEmpty(path)) {
				// qasClientPaht是指欲下载的文件的路径。
				File file = new File(path);
				// 以流的形式下载文件。
				InputStream fis = new BufferedInputStream(new FileInputStream(file));
				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				fis.close();
				// 清空response
				response.reset();
				// 设置response的Header
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/octet-stream");
				response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(downloadFileName, "UTF-8"));
				response.addHeader("Content-Length", "" + file.length());
				OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
				toClient.write(buffer);
				toClient.flush();
				log.info("finish download "+ downloadFileName + "...");
				toClient.close();
			}else {
				log.info("文件下载路径path不能为空...");
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.error("http DownloadClient exception: " + e.getMessage());
		}
		return response;
	}
}
