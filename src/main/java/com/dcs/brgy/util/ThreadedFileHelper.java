/*For manipulation and deletion of a file to avoid
Java.nio.file.FileSystemException: The process cannot access the file because it is being used by another process.*/

package com.dcs.brgy.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;

public class ThreadedFileHelper {

	private CountDownLatch doneCountdown;
	private File file;
	private String fileDest;

	public ThreadedFileHelper(File file, String fileDest, Integer waitForNSec) {
		this.file = file;
		this.fileDest = fileDest;
		this.doneCountdown = new CountDownLatch(waitForNSec);
	}

	public void createFile() throws InterruptedException {
		new Thread(() -> {
			writeFile();
			doneCountdown.countDown();
		}).start();

		new Thread(() -> {
			deleteFile();
			doneCountdown.countDown();
		}).start();

		doneCountdown.countDown();
	}

	private void writeFile() {
		try {
			byte[] fileContent;
			fileContent = Files.readAllBytes(file.toPath());
			Files.write(Paths.get(fileDest), fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteFile() {
		try {
			Files.deleteIfExists(file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			file.delete();
			e.printStackTrace();
		}
	}
}
