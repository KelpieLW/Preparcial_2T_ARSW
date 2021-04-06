var app = (function (){
	var apiClient;	
	var initialize= ()=>{
		// Initializing table
		apiClient=client;
		canadaResult =  client.getTotalCountryStatistics("Canada", retrieveHeaderStats);
		uSResult =  client.getTotalCountryStatistics("US", retrieveHeaderStats);
		colombiaResult =  client.getTotalCountryStatistics("Colombia", retrieveHeaderStats);
		chinaResult =  client.getTotalCountryStatistics("China", retrieveHeaderStats);



	}

	function wipeTable(tableName){
        // var table = document.getElementById(tableName);
        // table.getElementsByTagName("tbody")[0].innerHTML = table.rows[0].innerHTML;
        $("#"+tableName).empty();
    }

	var retrieveHeaderStats=(countryStats)=>{
		
		$("#headerCountries > tbody").append(
			`
			<tr>
				<td>${countryStats.countryName}</td>
				<td>${countryStats.dead}</td>
				<td>${countryStats.confirmed}</td>
				<td>${countryStats.recovered}</td>
			</tr>
			`
		);
	}

	var retriveGeneralCountrystats=(countryStats)=>{

		$("#countryTitleName").text(countryStats.countryName);
		$("#specificCountryGeneral > tbody").append(
			`
			<tr>
				<td>${"Confirmed"}</td>
				<td>${countryStats.confirmed}</td>				
			</tr>
			<tr>
				<td>${"Recovered"}</td>
				<td>${countryStats.recovered}</td>				
			</tr>
			<tr>
				<td>${"Dead"}</td>
				<td>${countryStats.dead}</td>				
			</tr>
			`
		);		
	}

	var retriveCountryAndProvincesStats=(countryStats)=>{
		let provinceList = countryStats.provinces;
		for (var i=0;i<provinceList.length;i++){
			$("#provincesTable > tbody").append(
				`
				<tr>
					<td>${provinceList[i].province}</td>
					<td>${provinceList[i].dead}</td>
					<td>${provinceList[i].confirmed}</td>
					<td>${provinceList[i].recovered}</td>
				</tr>
				
				`
			);	
		}
		
	}

	var searchCountry = (country)=>{
		wipeTable("provincesTableBody");		
		wipeTable("specificCountryGeneralBody");
		apiClient.getTotalCountryStatistics(country, retriveGeneralCountrystats);
		apiClient.getTotalCountryWithProvinceStatistics(country,retriveCountryAndProvincesStats);
	}

	return{
		initialize:function(){
			initialize();

		},

		searchCountry: (country)=>{
			searchCountry(country);
		}
	}
})();