class CountryCollection{
	
	constructor(items){		
		this.items=items;
	}
	
	first(){
		return new CountryPath(this.items[0])
	}
	
	find(index){
		return new CountryPath(this.items[index])
	}
	
	
	
	static get(){
		return new CountryCollection(document.querySelectorAll("path"))
	}
	
	for(funct){
	
	this.items.forEach(countryPath=>{
		funct(new CountryPath(countryPath))
		
	});
	}
}

class CountryPath{
		
		constructor(element){
			
			this.element=element
			this.setTooltip(`country:${this.name()}`)
		}
		
		name(){
			return this.element.getAttribute("id")
		}
	
	 fill(color){
		this.element.setAttribute("fill",color)
	
	}
	
	setPopulation(population)	{
		this.element.setAttribute("population",population)
	}
	
	setTooltip(string){
		this.element.setAttribute('title',string);
	}
	
	static findByName(name) {
		
		return new CountryPath(document.getElementById(name))
	}
	
	

}

class Response{
	
	constructor(object){	
		
		this.object=object	
		
	}
	
	population(){
		
		return this.object.population
	}
	
	region(){
		
		return this.object.region
		
	}
	
	subregion(){
		
		return this.object.subregion
	}
	
	area(){
		
		return this.object.area
	}
}



class CountryAPI{	
	
	static async findByName(name){
	
	const response= await fetch(`https://restcountries.com/v3.1/name/${name}`)
	
	
	
	return new Response((await response.json())[0])
	
	
		
	} 
	
}




CountryCollection.get().for(async countryPath =>{
	
const response=	await CountryAPI.findByName(countryPath.name())

countryPath.setTooltip('country')

if(response.region()=='Europe'){
	countryPath.fill("rgb(187,210,245)")
	return
}

if(response.region()=='Africa'){
	countryPath.fill("rgb(118,157,227)")
	return
}
if(response.region()=='Americas'){
 
 countryPath.fill("rgb(5, 107, 173)")
    return
 
}
if(response.region()=='Asia'){

countryPath.fill("rgb(127,179,213)")
return
}

if(response.region()=='Oceania'){

countryPath.fill("rgb(26,82,118)")
return
}
})
