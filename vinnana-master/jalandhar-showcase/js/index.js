var placesJSON;
var fairsJSON;
var personalitiesJSON;
var religiousJSON;

fetch("../JSON/places.json")
    .then(response => response.json())
    .then(data => {
        placesJSON = data;
    })


fetch("../JSON/fairs.json")
    .then(response => response.json())
    .then(data => {
        fairsJSON = data;
    })

fetch("../JSON/personalities.json")
    .then(response => response.json())
    .then(data => {
        personalitiesJSON = data;
    })

fetch("../JSON/religious.json")
    .then(response => response.json())
    .then(data => {
        religiousJSON = data;
    })



var things = document.getElementById("things");


function clearAll(x){
    var d;
    if(x === 'places'){
        d = placesJSON;
    }
    else if(x === 'fairs'){
        d = fairsJSON;
    }
    else if(x === 'personalities'){
        d = personalitiesJSON;
    }
    else{
        d = religiousJSON;
    }
    console.log('clicked');
    while(things.firstChild){
        things.removeChild(things.firstChild);
    }
    create(d, x);
}
    
function create(d, x){
    var h1 = document.createElement(h1);
    if(x === 'places'){
        h1.innerHTML=`Famous ${x}`;
    }
    else if(x === 'fairs'){
        h1.innerHTML=`Famous ${x}`;
    }
    else if(x === 'personalities'){
        h1.innerHTML=`Famous ${x}`;
    }
    else{
        h1.innerHTML=`Famous ${x} places`;
    }
    h1.setAttribute("style","font-size: 4em; text-transform: uppercase; font-family: 'Yellowtail';");
    h1.setAttribute("data-aos","fade-up");
    
    things.appendChild(h1);
    var i=0;
    for(;i<d.length;i++){
        var site = document.createElement("div");
        if(i%2==0){
            site.setAttribute("class","site");
            site.setAttribute("data-aos","fade-right");
        }
        else{            
            site.setAttribute("class","site alt");
            site.setAttribute("data-aos","fade-left");
        }
        
        var backURL = `background-image : url(${d[i].imagePath});`;
        var meta = document.createElement("div");
        meta.setAttribute("class","meta");
        
        var photo = document.createElement("div");
        photo.setAttribute("class","photo");
        photo.setAttribute("style", backURL)
       
        meta.appendChild(photo);
        site.appendChild(meta);
        
        var desc = document.createElement("div");
        desc.setAttribute("class","description");
        
        var h1 = document.createElement("h1");
        h1.innerHTML=d[i].name;
        
        var address = document.createElement("h2");
        address.innerHTML= d[i].address;

        var p = document.createElement("p");
        p.innerHTML = d[i].description;
        
        desc.appendChild(h1);
        desc.appendChild(address)
        desc.appendChild(p);
        site.appendChild(desc);
        things.appendChild(site);

    }
}
