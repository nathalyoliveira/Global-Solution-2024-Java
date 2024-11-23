document.addEventListener('DOMContentLoaded', function () {
    
    var editButtons = document.querySelectorAll('[data-bs-toggle="modal"]');

    editButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            
            var objetoId = this.getAttribute('data-id');
			
			var objetoLocalId = this.getAttribute('data-local-id');

            var modal = document.getElementById('myModal');
            
            
            var localIdInput = modal.querySelector('#localId');
            var sensorIdInput = modal.querySelector('#sensorId');
			var sensorLocalInput = modal.querySelector('#sensorLocal');
            
            if(localIdInput != null){
				localIdInput.value = objetoId;
			}
			
			if(sensorIdInput != null){
				sensorIdInput.value = objetoId;
			}
			
			if(sensorLocalInput != null){
				sensorLocalInput.value = objetoLocalId;
			}
        });
    });
    
    
  var deleteButtons = document.querySelectorAll('[data-bs-target="#confirmDeleteModal"]');

    deleteButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            var objetoId = this.getAttribute('data-id');
			var objetoLocalId = this.getAttribute('data-local-id');
            var deleteForm = document.getElementById('deleteForm');
            
            var localIdInput = document.getElementById('localIdToDelete');
            var sensorIdInput = document.getElementById('sensorIdToDelete');
            
            var tipoCultivoIdInput = document.getElementById('cultivoIdToDelete');
            
            if (localIdInput != null){
				localIdInput.value = objetoId;
				deleteForm.action = '/local/excluir/' + objetoId;
			}
			
			if(sensorIdInput != null){
				sensorIdInput.value = objetoId;
				deleteForm.action = '/sensor/excluir/' + objetoId;
			}
			
			if(tipoCultivoIdInput != null){
				tipoCultivoIdInput.value = objetoId;
				deleteForm.action = '/clientesTipoCultivo/excluir/' + objetoId;
			}
            
        });
    });
});
