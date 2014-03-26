var icons = [];

function loadIcons(iconNames) {
	for (var i = 0; i < iconNames.length; i++) { 
		icons.push(iconNames[i]);
		print(icons);
	}
}

loadIcons(['test.png', 'test2.png']);

print(icons.pop());
print(icons.pop());
