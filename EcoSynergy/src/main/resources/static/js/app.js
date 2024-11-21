document.addEventListener('DOMContentLoaded', function () {
    
    var editButtons = document.querySelectorAll('[data-bs-toggle="modal"]');

    editButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            
            var objetoId = this.getAttribute('data-id');

            var modal = document.getElementById('myModal');
            
            
            var clienteIdInput = modal.querySelector('#clienteId');
            var vendedorIdInput = modal.querySelector('#vendedorId');
            
            if(clienteIdInput != null){
				clienteIdInput.value = objetoId;
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
            
            var clientIdInput = document.getElementById('clientIdToDelete');
            var vendedorIdInput = document.getElementById('vendedorIdToDelete');
            
            var tipoCultivoIdInput = document.getElementById('cultivoIdToDelete');
            
            if (clientIdInput != null){
				clientIdInput.value = objetoId;
				deleteForm.action = '/clientes/excluir/' + objetoId;
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
