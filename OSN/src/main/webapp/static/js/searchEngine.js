$(document).ready(function(){
	
	$("#search").on("submit", function(e){
		
		e.preventDefault();
		
		$("#result-list").slideUp(400, function(){
			$("#result-list").empty();
			if($("#searchField").val().length > 0){
				var request = $.ajax({
	                url: "SearchServlet",
	                type: "GET",
	                data: {
	                	searchField: $("#searchField").val()
	                }
				});
				request.done(function(data, textStatus, jqXHR) {
					console.log(data);
					
					var status = data.status;
					if(status){
						switch(status){
							case "error 1":
								$("#result-list").append(
									"<li>" + 
										"Special characters not allowed: '" + $("#searchField").val() + "'"+
									"</li>"
								);
								$("#result-list").slideDown(400);
								return;
							
							case "error 2":
								$("#result-list").append(
									"<li>" + 
										"Character limit exceeded (max 50 characters)"+
									"</li>"
								);
								$("#result-list").slideDown(400);
								return;
							
							case "error 3":
								$("#result-list").append(
									"<li>" + 
										"Entered null value"+
									"</li>"
								);
								$("#result-list").slideDown(400);
								return;
								
						}
					}
					
					if(data.length == 0){
						$("#result-list").append(
							"<li>" + 
								"Images with tag '" + $("#searchField").val() + "not found '" +
							"</li>"
						);
						$("#result-list").slideDown(400);
						return;
					}
					
					data.forEach(function(link){
						$("#result-list").append(
							"<li>" + 
								"<a href='" + link + "'>" + link + "</a>" +
							"</li>"
						);
					});
					$("#result-list").slideDown(400);
	            });	            
			}else{
				$("#result-list").append(
					"<li>" + 
						"No tags inserted!" +
					"</li>"
				);
				$("#result-list").slideDown(400);
			}
		});
     });
	
});
