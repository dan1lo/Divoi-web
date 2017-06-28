var uploader = document.getElementById('uploader');
var fileButton = document.getElementById('fileButton');

fileButton.addEventListener('change', function(e){
	
	var file = e.target.files[0];
	
	var storageRef = firebase.storage().ref('imagens/'+file.name);
	
	storageRef.put(file);
	
});