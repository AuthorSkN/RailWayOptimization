
var map;
var lineList = [];
var pointList = [];
var markerClusters = [];

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 55.76, lng: 37.64},
        zoom: 8
    });
}

function addLine(line, visible){
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
    if( visible )
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

function addMarkerGroup(grIdxMarkers, st){
    var grMarkers = [];
    var picture, type;
    switch (st.getShape()){
        case 0: picture = google.maps.SymbolPath.CIRCLE; break;
        case 1: picture = 'M -1,1 1,1 1,-1 -1,-1 z'; break;
        case 2: picture = 'M -1,1 1,1, 0,-1 z';break;
    }
    for(var i = 0; i < grIdxMarkers.size(); i++){
        var marker = pointList[grIdxMarkers.get(i)];
        marker.icon.path = picture;
        marker.icon.fillColor =st.getColorFill();
        marker.icon.strokeColor = st.getColorContour();
        marker.icon.strokeWeight = st.getWeightContour();
        grMarkers.push(marker);
    }
    var markerCluster = new MarkerClusterer(map, grMarkers,{
        gridSize: 30,
        styles: [{
            fillColor: st.getColorFill(),
            strokeColor: st.getColorContour(),
            strokeWeight: st.getWeightContour(),
            shape: st.getShape()
        }]
    });
    markerClusters.push(markerCluster);
}


function addPoint(point, visible){
    var picture = {
        fillColor: point.getStyle().getColorFill(),
        fillOpacity: 1.0,
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

    if( visible )
        newPoint.setMap(map);
    pointList.push(newPoint);
}

function showPoint(idx, idxGroup){
    if (idx < pointList.length) {
        pointList[idx].setMap(map);
        if (idxGroup != -1)markerClusters[idxGroup].addMarker(pointList[idx]);
    }
}

function hidePoint(idx, idxGroup){
    if(idx < pointList.length){
        pointList[idx].setMap(null);
        if (idxGroup != -1)markerClusters[idxGroup].removeMarker(pointList[idx]);
    }
}

function clearPoints(){
    for(var i = 0; i < markerClusters.length; i++)
        markerClusters[0].clearMarkers();
    for(var i = 0; i < pointList.length; i++)
        pointList[0].setMap(null);
    markerClusters = [];
    pointList = [];
}

function clearLines(){
    for(var i = 0; i < lineList.length; i++)
        lineList[i].setMap(null);
    lineList = [];
}


