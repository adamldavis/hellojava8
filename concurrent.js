var concurrent = new JavaImporter(java.util, java.util.concurrent);
var Callable = Java.type("java.util.concurrent.Callable"); 
with (concurrent) {
	var executor = Executors.newCachedThreadPool();
	var tasks = new LinkedHashSet();
	for (var i=0; i < 200; i++) {
		var MyTask = Java.extend(Callable,{call: function() {print("task " + i)}})
		var task = new MyTask();
		tasks.add(task);
		executor.submit(task);
	}
	//executor.invokeAll(tasks); // oops
}

