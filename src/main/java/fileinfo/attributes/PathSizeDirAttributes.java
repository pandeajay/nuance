package fileinfo.attributes;

public class PathSizeDirAttributes {

	@Override
	public String toString() {
		return "PathSizeDirAttributes [fullPath=" + fullPath + ", size=" + size + ", isDirectory=" + isDirectory + "]";
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public boolean isDirectory() {
		return isDirectory;
	}

	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	long size;
	boolean isDirectory;
	String fullPath;

}
