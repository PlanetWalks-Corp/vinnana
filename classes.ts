class Person {
    PersonId: number;
    PersonFirstName: string;
    PersonLastName: string;
    Dob: string;
    Image: string[];
    Description: string;
    Profession: string;

    constructor(PersonId: number, PersonFirstName: string, PersonLastName: string, Dob: string, Image: string[], Description: string, Profession: string) {
        this.PersonId = PersonId;
        this.PersonFirstName = PersonFirstName;
        this.PersonLastName = PersonLastName;
        this.Dob = Dob;
        this.Image = Image;
        this.Description = Description;
        this.Profession = Profession;
    }
}

class FairsAndFestival {
    FairId: number;
    FairName: string;
    FairType: string;
    Description: string;
    Image: string[];
    constructor(FairId: number, FairName: string, FairType: string, Image: string[], Description: string) {
        this.FairId = FairId;
        this.FairName = FairName;
        this.FairType = FairType;
        this.Image = Image;
        this.Description = Description
    }
}

class Places{
	PlaceId: number;
	PlaceName: string;
	Image: string[];
	PlaceType: string;
	Description: string;
	Address: string;

	constructor(PlaceId: number, PlaceName: string, Image: string[], Popularity: number, PlaceType: string, Description: string, Address: string){
		this.PlaceId = PlaceId;
		this.PlaceName = PlaceName;
		this.Image = Image;
		this.PlaceType = PlaceType;
		this.Description = Description;
		this.Address = Address;
	}	
}

class City{
	CityId: number;
	CityName: string;
	Population: number;
	Geolocation: string;
	History: string;
	Climate: string;
	places: Places[];
	person: Person[];
	fairs_and_festivals: FairsAndFestival[];

	constructor(CityId: number, CityName: string, Population: number, Geolocation: string, History: string, Climate: string, places: Places[], person: Person[], fairs_and_festivals: FairsAndFestivals[]){
		this.CityId = CityId;
		this.CityName = CityName;
		this.Population = Population;
		this.Geolocation = Geolocation;
		this.History = History;
		this.Climate = Climate;
		this.places = places;
		this.person = person;
		this.fairs_and_festivals = fairs_and_festivals;
	}
}