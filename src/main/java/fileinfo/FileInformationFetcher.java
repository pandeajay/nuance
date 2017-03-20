package fileinfo;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import fileinfo.attributes.FileAttributes;
import fileinfo.attributes.PathSizeDirAttributes;

@Component
public interface FileInformationFetcher {
	List<PathSizeDirAttributes> fetchPathSizeAndIsFileDetails(String file) throws IOException;

	List<FileAttributes> fetchAllFileDetails(String file) throws IOException;
}
