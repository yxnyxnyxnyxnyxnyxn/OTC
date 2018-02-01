public class Directory{
	public static void main(String[]args){
		final Shell shell = new Shell();
		assert shell.path().equals("/");


		shell.cd("/")
		assert shell.path().equals("/");

		shell.cd("user/..")
		assert shell.path().equals("/");

		shell.cd("user").cd("local")
		shell.cd("../local").cd("./")
		assert shell.path().equals("user/local");

		shell.cd("..")
		assert shell.path().equals("/user");

		shell.cd("//lib///")
		assert shell.path().equals("/lib");



