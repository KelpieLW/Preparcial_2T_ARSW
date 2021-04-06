client = (function (){

	return{
		getTotalCountryStatistics: function(country, callback){
			var getStat = $.getJSON("/statistics/"+country, function(){
				response = getStat.responseText;
			}).done(()=>{
				callback(JSON.parse(getStat.responseText));
			}).fail(()=>{
				alert("Something went wrong with the query");
			});
		},

		getTotalCountryWithProvinceStatistics: function(country, callback){
			var getStat = $.getJSON("/statistics/provinces/"+country, ()=>{
				response = getStat.responseText;
			}).done(()=>{
				callback(JSON.parse(getStat.responseText));
			}).fail(()=>{
				alert("S");
			});
		}
	}
		
	 	

})();

