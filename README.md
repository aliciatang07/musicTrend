## left task 
-[x] refresh token automatically
-[x] setup the return body from http get 
-[x] finish the whole work flow: get release, get track, get audio analysis and feature,
-[x] feed into kafka periodically in streaming format(query api every hour)
-[ ] experiment partition number and topic number 


## further improvement after finishing spark side 
- [ ] generalize the streaming producer side for any other data 
from other api  


User study feasibility for streaming data volume 
https://www.musicbusinessworldwide.com/nearly-40000-tracks-are-now-being-added-to-spotify-every-single-day/#:~:text=That%2C%20as%20if%20you%20needed,million%20tracks%20per%20calendar%20month.



api info 
https://developer.spotify.com/documentation/web-api/

token format 
{
    "access_token": "BQAQjCxN38RcP6zdZZnxajR1C0VbbpCauq-fg3sOEIHpqLKKTCLOVzGi3MsGaJLzGMj72XRWJbnEi42tCBM",
    "token_type": "Bearer",
    "expires_in": 3600,
    "scope": ""
}


sample response from get new release 
sample query:
https://api.spotify.com/v1/browse/new-releases?country=CA&offset=0&limit=10
sample data 
```
{
  "albums": {
    "href": "https://api.spotify.com/v1/browse/new-releases?country=CA&offset=0&limit=10",
    "items": [
      {
        "album_type": "single",
        "artists": [
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/5f7VJjfbwm532GiveGC0ZK"
            },
            "href": "https://api.spotify.com/v1/artists/5f7VJjfbwm532GiveGC0ZK",
            "id": "5f7VJjfbwm532GiveGC0ZK",
            "name": "Lil Baby",
            "type": "artist",
            "uri": "spotify:artist:5f7VJjfbwm532GiveGC0ZK"
          }
        ],
        "available_markets": [
          "AD",
          "AE",
          "AR",
          "AT",
          "AU",
          "BE",
          "BG",
          "GR",    
        ],
        "external_urls": {
          "spotify": "https://open.spotify.com/album/6ZTl8hHvYNuEg4Mk8yxz75"
        },
        "href": "https://api.spotify.com/v1/albums/6ZTl8hHvYNuEg4Mk8yxz75",
        "id": "6ZTl8hHvYNuEg4Mk8yxz75",
        "images": [
          {
            "height": 640,
            "url": "https://i.scdn.co/image/ab67616d0000b273c0ee50f512295c64a2c8af3d",
            "width": 640
          },
          {
            "height": 300,
            "url": "https://i.scdn.co/image/ab67616d00001e02c0ee50f512295c64a2c8af3d",
            "width": 300
          },
          {
            "height": 64,
            "url": "https://i.scdn.co/image/ab67616d00004851c0ee50f512295c64a2c8af3d",
            "width": 64
          }
        ],
        "name": "The Bigger Picture",
        "release_date": "2020-06-12",
        "release_date_precision": "day",
        "total_tracks": 1,
        "type": "album",
        "uri": "spotify:album:6ZTl8hHvYNuEg4Mk8yxz75"
      },
     }
     }
```