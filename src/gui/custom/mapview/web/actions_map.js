
var map;
var lineList = [];
var pointList = [];
var markerCluster;

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
    if(line.isVisible())
        newLine.setMap(map);
    lineList.push(newLine);
}

function showLine(id){
    if(id < lineList.length){
        lineList[id].setMap(map);
    }
}

function clustering(){
    markerCluster = new MarkerClusterer(map, pointList, {
        imagePath: './image/m',
        gridSize: 30
    });
}

function hideLine(id){
    if(id < lineList.length){
        lineList[id].setMap(null);
    }
}

function addPoint(point){
    var picture = {
        fillColor: point.getStyle().getColorFill(),
        fillOpacity: point.getStyle().getOpacity(),
        scale: point.getWeight(),
        strokeColor: point.getStyle().getColorContour(),
        strokeWeight: point.getStyle().getWeightContour()
    };
    switch (point.getStyle().getShape()){
        case 0: picture.path = google.maps.SymbolPath.CIRCLE; break;
        case 1: picture.path = 'M -1,1 1,1 1,-1 -1,-1 z'; break;
        case 2: picture.path = 'M -1,1 1,1, 0,-1 z';break;
    }
    var newPoint = new google.maps.Marker({
        position: {lat: point.getLatitude(), lng: point.getLongitude()},
        title: point.getTitle(),
        icon: picture
    });

    newPoint.setMap(map);
    pointList.push(newPoint);
}


