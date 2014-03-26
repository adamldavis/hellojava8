var imports = new JavaImporter(java.util, java.io, java.nio.file);
with (imports) {
	var paths = new LinkedList();
	print(paths instanceof LinkedList); // true
	paths.add(Paths.get("file1"));
	paths.add(Paths.get("file2"));
	paths.add(Paths.get("file3"));
	print(paths)

	for (var i=0; i < paths.size(); i++) 
		Files.newOutputStream(paths.get(i))
			.write("test\n".getBytes());
}

