package tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import fileinfo.attributes.FileAttributes;
import fileinfo.controller.FileController;
import junit.framework.TestCase;

public class FileInfoApplicationTests extends TestCase {

	Gson objGson = new GsonBuilder().setPrettyPrinting().create();
	List<String> allFileNames = new ArrayList<String>();

	protected void setUp() {
		File testFile = new File("test");
		if (testFile.exists()) {
			testFile.delete();
		}
		testFile.mkdir();
		allFileNames.add(testFile.getAbsolutePath());
		File file1 = new File("test\\file1.txt");
		try {
			file1.createNewFile();
			allFileNames.add(file1.getAbsolutePath());
		} catch (Exception ex) {

		}

		File subDir = new File("test\\test2");
		subDir.mkdirs();
		allFileNames.add(subDir.getAbsolutePath());

	}

	@Test
	public void testNmberOFFiles() {
		File testFile = new File("test");
		String str = FileController.getAllFileDetails(testFile.getAbsolutePath());
		ArrayList<FileAttributes> files = objGson.fromJson(str, new TypeToken<ArrayList<FileAttributes>>() {
		}.getType());
		assertEquals(files.size(), allFileNames.size());
	}

	@Test
	public void testPathOFFiles() {
		File testFile = new File("test");
		String str = FileController.getAllFileDetails(testFile.getAbsolutePath());
		ArrayList<FileAttributes> files = objGson.fromJson(str, new TypeToken<ArrayList<FileAttributes>>() {
		}.getType());
		for (FileAttributes file : files) {
			assertTrue(allFileNames.contains(file.getFileName()));
		}
	}

}
