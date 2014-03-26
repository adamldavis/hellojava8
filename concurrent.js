var concurrent = new JavaImporter(java.util, java.util.concurrent);
var Callable = Java.type("java.util.concurrent.Callable"); 
with (concurrent) {
	var executor = Executors.newCachedThreadPool();
	var tasks = new LinkedHashSet();
	for (var i=0; i < 200; i++) {
		var task = Java.extend(Callable, {call: function() {print("task " + i)}})
		tasks.add(task)
		task.call();
		//executor.submit(task) // doesn't work
	}
//	executor.invokeAll(tasks); //also doesn't work
}

