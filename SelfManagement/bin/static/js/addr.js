var map;
var geocoder;
var bounds;
var markers = [];

/**
 *初期化
 */
function initialize() {
    geocoder = new google.maps.Geocoder();
    bounds = new google.maps.LatLngBounds();
    
    var latlng = new google.maps.LatLng(35.681272, 139.766322);
    var opts = {
        zoom: 10,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    map = new google.maps.Map(document.getElementById("map_canvas"), opts);
    
    // 画面から取得した場所よりマーカーをマップ上に設定
    setMarkers(false);
}

/**
 *マップにマーカーを設定
 *btnFlag：true(画面でボタンで呼び出し)、false(画面で呼び出しではない)
 */
function setMarkers(btnDown) {
    var isEmpty = true;
    var addresses = document.getElementsByName("addresses");

    // マーカーを設定する前に一回クリアする
    removeAllMarkers();

    for (var i = 0; i < addresses.length; i++) {
        var address = addresses[i];
        
        if(address.value) {
            isEmpty = false;
            
            // 座標取得メソッドを呼び出し
            codeAddress(address.value, String(i+1));
        }else{
            break;
        }
    }

    if(btnDown && isEmpty) {
        alert("場所を入力してください。");
        return;
    }

    // 複数座標すべてに合わせて表示領域を自動調整します。
    //map.fitBounds(bounds);   // auto-zoom
    //map.panToBounds(bounds); // auto-center
}

/**
 *場所の文字列により座標取得
 */
function codeAddress(address, markerLabel) {
    if (geocoder) {
        geocoder.geocode({ 'address': address,'region': 'jp'},function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                var m_pos = results[0].geometry.location;
                map.setCenter(m_pos);
                for (var r in results) {
                    if (results[r].geometry) {
                        var position = results[r].geometry.location;

                        // bounds.extend(position);

                        // マーカーを地図に追加する
                        addMarker(position, markerLabel);
                    }
                }
            }
            else{
                alert("Geocode 取得に失敗しました reason: "+ status);
            }
        });
    }
}


/**
 *Adds a marker to the map and push to the array.
 */
function addMarker(position, markerLabel) {
    var marker = new google.maps.Marker({
        position: position,
        label:markerLabel,
        map: map
    });

    marker.addListener('click', function() {
       removeMarker(this);
    });

    markers.push(marker);
}


/**
 *Remove the marker witch is clicked.
 */
function removeMarker(marker) {
    marker.setMap(null);
}

/**
 *Remove all of the marker in map.
 */
function removeAllMarkers() {
    for(var i in markers) {
        removeMarker(markers[i]);
    }
    markers = [];
}

/**
 *全部の場所をクリアする.
 */
function clearAll() {
    // マーカーを全部クリアする
    removeAllMarkers();
    
    // 場所入力ランの内容を全部クリアする
    var addresses = document.getElementsByName("addresses");
    for (var i = 0; i < addresses.length; i++) {
        var address = addresses[i];
        address.value = "";
    }
}

