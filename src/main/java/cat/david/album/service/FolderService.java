package cat.david.album.service;

import java.util.List;

import cat.david.album.model.File;
import cat.david.album.model.Folder;

public interface FolderService {

	public List<Folder> listFolders(Long folderId);

	public List<File> listFiles(Long folderId);

}
