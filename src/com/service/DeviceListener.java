package com.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeviceListener")
public class DeviceListener extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String loggedMessage = "******Device Message Logger*******";
	private int fileCounter = 1;

	public DeviceListener() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("file");
		String output = "";
		String st;
		File file = new File("C:\\Users\\yogi8\\Documents\\My Files\\LFApplication\\" + fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
			while ((st = br.readLine()) != null) {
				output = output + System.lineSeparator() + st;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		response.getWriter().println(output);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		
		try {
			InputStream inputStream = request.getInputStream();
			if (null != inputStream) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("No message in the request");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("REQ: "+ stringBuilder.toString());
		String logMessage = stringBuilder.toString();
		prepareFileForLogger();
		writeMessageToFile(System.lineSeparator() + LocalDateTime.now() + " ************* " + logMessage);
		response.getWriter().println(logMessage);
	}

	private void prepareFileForLogger() throws IOException {
		if (getCurrentFile().exists() && getCurrentFile().length() > 524288000L) {
			fileCounter++;
		}
		if (!getCurrentFile().exists()) {
			getCurrentFile().createNewFile();
			writeMessageToFile("******Device Message Logger*******");
		}
	}

	private File getCurrentFile() {
		return new File(
				"C:\\Users\\yogi8\\Documents\\My Files\\LFApplication\\DeviceStatusLogger_" + fileCounter + ".txt");
	}

	private void writeMessageToFile(String logMessage) {
		Path p = Paths.get(
				"C:\\Users\\yogi8\\Documents\\My Files\\LFApplication\\DeviceStatusLogger_" + fileCounter + ".txt");
		try (BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {
			writer.write(logMessage);
		} catch (IOException ioe) {
			System.err.format("IOException: %s%n", ioe);
		}
	}

}
