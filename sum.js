var data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]; 

print(typeof 1)
print(typeof Array)
print(data instanceof Array) //true
 var filtered = data.filter(function(i) {   return i % 2 == 0; }); print(filtered);  var sumOfFiltered = filtered.reduce(function(acc, next) {   return acc + next; }, 0);
 print(sumOfFiltered);
