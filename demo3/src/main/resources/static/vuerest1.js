
var commAPI = Vue.resource("http://localhost:8080/estudiante{/id}")

var app = new Vue({
	el: '#app',
	data: {
		mensaje: 'Hola Lola',
		mensaje2: "nada creado aun...",
		estudiantes: [],
		nom: ""
	}, 
	created: function(){
		this.mensaje2 = "Hola TOOOODO CREADO"
		//commAPI.get().then(result => console.log(result) )
		commAPI.get().then(result => 
			result.json().then(data => this.estudiantes = data)
		)
	},
	methods: {
		guardar:function(){
			//console.log("guardando...")
			var mm = {nombre:this.nom}
			
			console.log(mm)
			commAPI.save({},mm).then(result => 
				result.json().then(data => 
					{ console.log(data) }
						
				)
			)
			
			this.nom = ""
		}
	}
	
})
	
	
	


