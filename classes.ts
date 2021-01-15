class Person {
    personId: number;
    personFirstName: string;
    personLastName: string;
    dob: Date;
    imageName: string;
    description: string;
    profession: string;
    age: number;

    constructor(personId: number, personFirstName: string, personLastName: string, dob: Date, imageName: string, description: string, profession: string, age: number) { }
}

class Fairs {
    fairId: number;
    fairName: string;
    fairType: string;
    description: string;
    imageName: string;
    constructor(fairId: number, fairName: string, fairType: string, imageName: string, description: string) { }
}

class Places{
	placeId: number;
	placeName: string;
	imageName: string;
	placeType: string;
	description: string;
	address: string;

	constructor(placeId: number, placeName: string, imageName: string, placeType: string, description: string, address: string){}	
}

class Image{
	imageId: number;
	imageName: string;

	constructor(imageId: number, imageName:string)
}
class Album{
	albumId: number;
	albumName: string;
	image: Image[];

	constructor(albumId: number, albuName: string, image: Image[]){
	}
}
class City{
	cityId: number;
	cityName: string;
	population: number;
	geoLocation: string;
	history: string;
	weatherCondition: string;
	places: Places[];
	person: Person[];
	fair: Fairs[];
	album: Album;

	constructor(cityId: number, cityName: string, population: number, geolocation: string, history: string, weatherCondition: string, places: Places[], person: Person[], fair: Fairs[], album: Album){}
}