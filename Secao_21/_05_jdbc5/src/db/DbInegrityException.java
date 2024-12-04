package db;

public class DbInegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DbInegrityException(String msg) {
		super(msg);
	}
}
