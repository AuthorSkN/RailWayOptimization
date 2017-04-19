
var myMap;
var circleList = [];

function initMap() {
    myMap = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 55.76, lng: 37.64},
        zoom: 8
    });
}

function drawLine(){
    var flightPlanCoordinates = [{ lat:56.10611363874518, lng: 40.373461832170534},
        {lat: 56.2264108663317, lng: 40.61104117787365},
        {lat: 56.29598950304121, lng: 40.90692364985676},
        {lat: 56.33110001070675, lng: 40.94537579829427},
        {lat: 56.367702515893484, lng: 41.09369122798176},
        {lat: 56.408838185873115, lng: 41.14587628657549},
        {lat: 56.444605149892865, lng: 41.16372906977865},
        {lat: 56.45449217723618, lng: 41.20080792720051},
        {lat: 56.503275395702964, lng: 41.1894513181561},
        {lat: 56.606420837622565, lng: 41.21417055643736},
        { lat: 56.77087602378307, lng: 41.32062321829192}
    ];
    var flightPath = new google.maps.Polyline({
        path: flightPlanCoordinates,
        geodesic: true,
        strokeColor: '#FF0000',
        strokeOpacity: 1.0,
        strokeWeight: 2
    });

    flightPath.setMap(myMap);
}

