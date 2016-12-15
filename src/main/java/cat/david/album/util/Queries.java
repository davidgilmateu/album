package cat.david.album.util;

public class Queries {

	public static final String ALL_FILES_IN_FOLDER		=	"FROM File   WHERE folder=:f";
	public static final String ALL_FOLDERS_IN_FOLDER	=	"FROM Folder WHERE folder=:f";
}
