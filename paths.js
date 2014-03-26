var imports = new JavaImporter(java.util, java.io, java.nio.file);
with (imports) {
	var paths = new LinkedList();
	print(paths instanceof LinkedList); // true
	paths.add(Paths.get("file1"));
	paths.add(Paths.get("file2"));
	paths.add(Paths.get("file3"));
	print(paths)

	paths.forEach(function(path) {
		Files.newOutputStream(path)
			.write("test\n".getBytes());}
		);
}

