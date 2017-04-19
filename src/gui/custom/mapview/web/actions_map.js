
var map;
var lineList = [];

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 55.76, lng: 37.64},
        zoom: 8
    });
}

function addLine(line){
    var points = line.getPoints();
    var coordinates = [];
    for(var i = 0; i < points.size(); i++) {
        coordinates.push(
            { lat: points.get(i).getLatitude(), lng: points.get(i).getLongitude()}
        );
    }
    var newLine = new google.maps.Polyline({
        path: coordinates,
        geodesic:true,
        strokeColor: line.getColor(),
        strokeOpacity: 1.0,
        strokeWeight: line.getWeight()
    });
    newLine.setMap(map);
    lineList.push(newLine);
}

function showLine(id){
    if(id < lineList.length){
        lineList[id].setMap(map);
    }
}

function hideLine(id){
    if(id < lineList.length){
        lineList[id].setMap(null);
    }
}


