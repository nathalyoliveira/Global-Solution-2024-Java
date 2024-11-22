document.addEventListener('DOMContentLoaded', function () {
    
    var editButtons = document.querySelectorAll('[data-bs-toggle="modal"]');

    editButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            
            var objetoId = this.getAttribute('data-id');

            var modal = document.getElementById('myModal');
            
            
            var localIdInput = modal.querySelector('#localId');
            var vendedorIdInput = modal.querySelector('#vendedorId');
            
            if(localIdInput != null){
				localIdInput.value = objetoId;
			}
			
			if(vendedorIdInput != null){
				vendedorIdInput.value = objetoId;
			}
        });
    });
    
    
  var deleteButtons = document.querySelectorAll('[data-bs-target="#confirmDeleteModal"]');

    deleteButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            var objetoId = this.getAttribute('data-id');
            var deleteForm = document.getElementById('deleteForm');
            
            var localIdInput = document.getElementById('localIdToDelete');
            var vendedorIdInput = document.getElementById('vendedorIdToDelete');
            
            var tipoCultivoIdInput = document.getElementById('cultivoIdToDelete');
            
            if (localIdInput != null){
				localIdInput.value = objetoId;
				deleteForm.action = '/local/excluir/' + objetoId;
			}
			
			if(vendedorIdInput != null){
				vendedorIdInput.value = objetoId;
				deleteForm.action = '/vendedores/excluir/' + objetoId;
			}
			
			if(tipoCultivoIdInput != null){
				tipoCultivoIdInput.value = objetoId;
				deleteForm.action = '/clientesTipoCultivo/excluir/' + objetoId;
			}
            
        });
    });
});
