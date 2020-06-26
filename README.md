## left task 
-[x] refresh token automatically
-[x] setup the return body from http get 
-[x] finish the whole work flow: get release, get track, get audio analysis and feature,
-[ ] feed into kafka periodically in streaming format(query api every hour)
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
          "BH",
          "BO",
          "BR",
          "CA",
          "CH",
          "CL",
          "CO",
          "CR",
          "CY",
          "CZ",
          "DE",
          "DK",
          "DO",
          "DZ",
          "EC",
          "EE",
          "EG",
          "ES",
          "FI",
          "FR",
          "GB",
          "GR",
          "GT",
          "HK",
          "HN",
          "HU",
          "ID",
          "IE",
          "IL",
          "IN",
          "IS",
          "IT",
          "JO",
          "JP",
          "KW",
          "LB",
          "LI",
          "LT",
          "LU",
          "LV",
          "MA",
          "MC",
          "MT",
          "MX",
          "MY",
          "NI",
          "NL",
          "NO",
          "NZ",
          "OM",
          "PA",
          "PE",
          "PH",
          "PL",
          "PS",
          "PT",
          "PY",
          "QA",
          "RO",
          "SA",
          "SE",
          "SG",
          "SK",
          "SV",
          "TH",
          "TN",
          "TR",
          "TW",
          "US",
          "UY",
          "VN",
          "ZA"
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
      {
        "album_type": "single",
        "artists": [
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/54lUDwCk35ihJuK3yJCqHA"
            },
            "href": "https://api.spotify.com/v1/artists/54lUDwCk35ihJuK3yJCqHA",
            "id": "54lUDwCk35ihJuK3yJCqHA",
            "name": "James Barker Band",
            "type": "artist",
            "uri": "spotify:artist:54lUDwCk35ihJuK3yJCqHA"
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
          "BH",
          "BO",
          "BR",
          "CA",
          "CH",
          "CL",
          "CO",
          "CR",
          "CY",
          "CZ",
          "DE",
          "DK",
          "DO",
          "DZ",
          "EC",
          "EE",
          "EG",
          "ES",
          "FI",
          "FR",
          "GB",
          "GR",
          "GT",
          "HK",
          "HN",
          "HU",
          "ID",
          "IE",
          "IL",
          "IN",
          "IS",
          "IT",
          "JO",
          "JP",
          "KW",
          "LB",
          "LI",
          "LT",
          "LU",
          "LV",
          "MA",
          "MC",
          "MT",
          "MX",
          "MY",
          "NI",
          "NL",
          "NO",
          "NZ",
          "OM",
          "PA",
          "PE",
          "PH",
          "PL",
          "PS",
          "PT",
          "PY",
          "QA",
          "RO",
          "SA",
          "SE",
          "SG",
          "SK",
          "SV",
          "TH",
          "TN",
          "TR",
          "TW",
          "US",
          "UY",
          "VN",
          "ZA"
        ],
        "external_urls": {
          "spotify": "https://open.spotify.com/album/3FSEnz3rAylZiOzasKGG5T"
        },
        "href": "https://api.spotify.com/v1/albums/3FSEnz3rAylZiOzasKGG5T",
        "id": "3FSEnz3rAylZiOzasKGG5T",
        "images": [
          {
            "height": 640,
            "url": "https://i.scdn.co/image/ab67616d0000b273fac9de636072504b05e49795",
            "width": 640
          },
          {
            "height": 300,
            "url": "https://i.scdn.co/image/ab67616d00001e02fac9de636072504b05e49795",
            "width": 300
          },
          {
            "height": 64,
            "url": "https://i.scdn.co/image/ab67616d00004851fac9de636072504b05e49795",
            "width": 64
          }
        ],
        "name": "Summer Time",
        "release_date": "2020-06-12",
        "release_date_precision": "day",
        "total_tracks": 1,
        "type": "album",
        "uri": "spotify:album:3FSEnz3rAylZiOzasKGG5T"
      },
      {
        "album_type": "single",
        "artists": [
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/1MXZ0hsGic96dWRDKwAwdr"
            },
            "href": "https://api.spotify.com/v1/artists/1MXZ0hsGic96dWRDKwAwdr",
            "id": "1MXZ0hsGic96dWRDKwAwdr",
            "name": "Tyla Yaweh",
            "type": "artist",
            "uri": "spotify:artist:1MXZ0hsGic96dWRDKwAwdr"
          },
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/246dkjvS1zLTtiykXe5h60"
            },
            "href": "https://api.spotify.com/v1/artists/246dkjvS1zLTtiykXe5h60",
            "id": "246dkjvS1zLTtiykXe5h60",
            "name": "Post Malone",
            "type": "artist",
            "uri": "spotify:artist:246dkjvS1zLTtiykXe5h60"
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
          "BH",
          "BO",
          "BR",
          "CA",
          "CH",
          "CL",
          "CO",
          "CR",
          "CY",
          "CZ",
          "DE",
          "DK",
          "DO",
          "DZ",
          "EC",
          "EE",
          "EG",
          "ES",
          "FI",
          "FR",
          "GB",
          "GR",
          "GT",
          "HK",
          "HN",
          "HU",
          "ID",
          "IE",
          "IL",
          "IN",
          "IS",
          "IT",
          "JO",
          "JP",
          "KW",
          "LB",
          "LI",
          "LT",
          "LU",
          "LV",
          "MA",
          "MC",
          "MT",
          "MX",
          "MY",
          "NI",
          "NL",
          "NO",
          "NZ",
          "OM",
          "PA",
          "PE",
          "PH",
          "PL",
          "PS",
          "PT",
          "PY",
          "QA",
          "RO",
          "SA",
          "SE",
          "SG",
          "SK",
          "SV",
          "TH",
          "TN",
          "TR",
          "TW",
          "US",
          "UY",
          "VN",
          "ZA"
        ],
        "external_urls": {
          "spotify": "https://open.spotify.com/album/2PFiZ23ZyPTcgwmXk4X6o0"
        },
        "href": "https://api.spotify.com/v1/albums/2PFiZ23ZyPTcgwmXk4X6o0",
        "id": "2PFiZ23ZyPTcgwmXk4X6o0",
        "images": [
          {
            "height": 640,
            "url": "https://i.scdn.co/image/ab67616d0000b273e9f7839f5017f87ca7f5e4f0",
            "width": 640
          },
          {
            "height": 300,
            "url": "https://i.scdn.co/image/ab67616d00001e02e9f7839f5017f87ca7f5e4f0",
            "width": 300
          },
          {
            "height": 64,
            "url": "https://i.scdn.co/image/ab67616d00004851e9f7839f5017f87ca7f5e4f0",
            "width": 64
          }
        ],
        "name": "Tommy Lee (feat. Post Malone)",
        "release_date": "2020-06-12",
        "release_date_precision": "day",
        "total_tracks": 1,
        "type": "album",
        "uri": "spotify:album:2PFiZ23ZyPTcgwmXk4X6o0"
      },
      {
        "album_type": "single",
        "artists": [
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/0ErzCpIMyLcjPiwT4elrtZ"
            },
            "href": "https://api.spotify.com/v1/artists/0ErzCpIMyLcjPiwT4elrtZ",
            "id": "0ErzCpIMyLcjPiwT4elrtZ",
            "name": "NLE Choppa",
            "type": "artist",
            "uri": "spotify:artist:0ErzCpIMyLcjPiwT4elrtZ"
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
          "BH",
          "BO",
          "BR",
          "CA",
          "CH",
          "CL",
          "CO",
          "CR",
          "CY",
          "CZ",
          "DE",
          "DK",
          "DO",
          "DZ",
          "EC",
          "EE",
          "EG",
          "ES",
          "FI",
          "FR",
          "GB",
          "GR",
          "GT",
          "HK",
          "HN",
          "HU",
          "ID",
          "IE",
          "IL",
          "IN",
          "IS",
          "IT",
          "JO",
          "JP",
          "KW",
          "LB",
          "LI",
          "LT",
          "LU",
          "LV",
          "MA",
          "MC",
          "MT",
          "MX",
          "MY",
          "NI",
          "NL",
          "NO",
          "NZ",
          "OM",
          "PA",
          "PE",
          "PH",
          "PL",
          "PS",
          "PT",
          "PY",
          "QA",
          "RO",
          "SA",
          "SE",
          "SG",
          "SK",
          "SV",
          "TH",
          "TN",
          "TR",
          "TW",
          "US",
          "UY",
          "VN",
          "ZA"
        ],
        "external_urls": {
          "spotify": "https://open.spotify.com/album/2qwWZ9YSvlLDGRdw3W0vTb"
        },
        "href": "https://api.spotify.com/v1/albums/2qwWZ9YSvlLDGRdw3W0vTb",
        "id": "2qwWZ9YSvlLDGRdw3W0vTb",
        "images": [
          {
            "height": 640,
            "url": "https://i.scdn.co/image/ab67616d0000b2739a41372e044d56d48f9e5d96",
            "width": 640
          },
          {
            "height": 300,
            "url": "https://i.scdn.co/image/ab67616d00001e029a41372e044d56d48f9e5d96",
            "width": 300
          },
          {
            "height": 64,
            "url": "https://i.scdn.co/image/ab67616d000048519a41372e044d56d48f9e5d96",
            "width": 64
          }
        ],
        "name": "Shotta Flow 5",
        "release_date": "2020-06-12",
        "release_date_precision": "day",
        "total_tracks": 1,
        "type": "album",
        "uri": "spotify:album:2qwWZ9YSvlLDGRdw3W0vTb"
      },
      {
        "album_type": "single",
        "artists": [
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/4ETSs924pXMzjIeD6E9b4u"
            },
            "href": "https://api.spotify.com/v1/artists/4ETSs924pXMzjIeD6E9b4u",
            "id": "4ETSs924pXMzjIeD6E9b4u",
            "name": "Surfaces",
            "type": "artist",
            "uri": "spotify:artist:4ETSs924pXMzjIeD6E9b4u"
          },
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/3PhoLpVuITZKcymswpck5b"
            },
            "href": "https://api.spotify.com/v1/artists/3PhoLpVuITZKcymswpck5b",
            "id": "3PhoLpVuITZKcymswpck5b",
            "name": "Elton John",
            "type": "artist",
            "uri": "spotify:artist:3PhoLpVuITZKcymswpck5b"
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
          "BH",
          "BO",
          "BR",
          "CA",
          "CH",
          "CL",
          "CO",
          "CR",
          "CY",
          "CZ",
          "DE",
          "DK",
          "DO",
          "DZ",
          "EC",
          "EE",
          "EG",
          "ES",
          "FI",
          "FR",
          "GB",
          "GR",
          "GT",
          "HK",
          "HN",
          "HU",
          "ID",
          "IE",
          "IL",
          "IN",
          "IS",
          "IT",
          "JO",
          "JP",
          "KW",
          "LB",
          "LI",
          "LT",
          "LU",
          "LV",
          "MA",
          "MC",
          "MT",
          "MX",
          "MY",
          "NI",
          "NL",
          "NO",
          "NZ",
          "OM",
          "PA",
          "PE",
          "PH",
          "PL",
          "PS",
          "PT",
          "PY",
          "QA",
          "RO",
          "SA",
          "SE",
          "SG",
          "SK",
          "SV",
          "TH",
          "TN",
          "TR",
          "TW",
          "US",
          "UY",
          "VN",
          "ZA"
        ],
        "external_urls": {
          "spotify": "https://open.spotify.com/album/0smKCfZ1XlApoqIg3AG3Dc"
        },
        "href": "https://api.spotify.com/v1/albums/0smKCfZ1XlApoqIg3AG3Dc",
        "id": "0smKCfZ1XlApoqIg3AG3Dc",
        "images": [
          {
            "height": 640,
            "url": "https://i.scdn.co/image/ab67616d0000b2738e328008ca97beb55998b0b5",
            "width": 640
          },
          {
            "height": 300,
            "url": "https://i.scdn.co/image/ab67616d00001e028e328008ca97beb55998b0b5",
            "width": 300
          },
          {
            "height": 64,
            "url": "https://i.scdn.co/image/ab67616d000048518e328008ca97beb55998b0b5",
            "width": 64
          }
        ],
        "name": "Learn To Fly (with Elton John)",
        "release_date": "2020-06-12",
        "release_date_precision": "day",
        "total_tracks": 1,
        "type": "album",
        "uri": "spotify:album:0smKCfZ1XlApoqIg3AG3Dc"
      },
      {
        "album_type": "single",
        "artists": [
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/02kJSzxNuaWGqwubyUba0Z"
            },
            "href": "https://api.spotify.com/v1/artists/02kJSzxNuaWGqwubyUba0Z",
            "id": "02kJSzxNuaWGqwubyUba0Z",
            "name": "G-Eazy",
            "type": "artist",
            "uri": "spotify:artist:02kJSzxNuaWGqwubyUba0Z"
          },
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/76yeOnINtQSXyoEHbkYmtY"
            },
            "href": "https://api.spotify.com/v1/artists/76yeOnINtQSXyoEHbkYmtY",
            "id": "76yeOnINtQSXyoEHbkYmtY",
            "name": "Drew Love",
            "type": "artist",
            "uri": "spotify:artist:76yeOnINtQSXyoEHbkYmtY"
          },
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/0VvNvCZj4gZJZVsnIm99GJ"
            },
            "href": "https://api.spotify.com/v1/artists/0VvNvCZj4gZJZVsnIm99GJ",
            "id": "0VvNvCZj4gZJZVsnIm99GJ",
            "name": "JAHMED",
            "type": "artist",
            "uri": "spotify:artist:0VvNvCZj4gZJZVsnIm99GJ"
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
          "BH",
          "BO",
          "BR",
          "CA",
          "CH",
          "CL",
          "CO",
          "CR",
          "CY",
          "CZ",
          "DE",
          "DK",
          "DO",
          "DZ",
          "EC",
          "EE",
          "EG",
          "ES",
          "FI",
          "FR",
          "GB",
          "GR",
          "GT",
          "HK",
          "HN",
          "HU",
          "ID",
          "IE",
          "IL",
          "IN",
          "IS",
          "IT",
          "JO",
          "JP",
          "KW",
          "LB",
          "LI",
          "LT",
          "LU",
          "LV",
          "MA",
          "MC",
          "MT",
          "MX",
          "MY",
          "NI",
          "NL",
          "NO",
          "NZ",
          "OM",
          "PA",
          "PE",
          "PH",
          "PL",
          "PS",
          "PT",
          "PY",
          "QA",
          "RO",
          "SA",
          "SE",
          "SG",
          "SK",
          "SV",
          "TH",
          "TN",
          "TR",
          "TW",
          "US",
          "UY",
          "VN",
          "ZA"
        ],
        "external_urls": {
          "spotify": "https://open.spotify.com/album/59d24jPWT0kjF3asDCj02a"
        },
        "href": "https://api.spotify.com/v1/albums/59d24jPWT0kjF3asDCj02a",
        "id": "59d24jPWT0kjF3asDCj02a",
        "images": [
          {
            "height": 640,
            "url": "https://i.scdn.co/image/ab67616d0000b2730d9833f0a5b736891f30d083",
            "width": 640
          },
          {
            "height": 300,
            "url": "https://i.scdn.co/image/ab67616d00001e020d9833f0a5b736891f30d083",
            "width": 300
          },
          {
            "height": 64,
            "url": "https://i.scdn.co/image/ab67616d000048510d9833f0a5b736891f30d083",
            "width": 64
          }
        ],
        "name": "Love Is Gone",
        "release_date": "2020-06-12",
        "release_date_precision": "day",
        "total_tracks": 1,
        "type": "album",
        "uri": "spotify:album:59d24jPWT0kjF3asDCj02a"
      },
      {
        "album_type": "single",
        "artists": [
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/46SHBwWsqBkxI7EeeBEQG7"
            },
            "href": "https://api.spotify.com/v1/artists/46SHBwWsqBkxI7EeeBEQG7",
            "id": "46SHBwWsqBkxI7EeeBEQG7",
            "name": "Kodak Black",
            "type": "artist",
            "uri": "spotify:artist:46SHBwWsqBkxI7EeeBEQG7"
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
          "BH",
          "BO",
          "BR",
          "CA",
          "CH",
          "CL",
          "CO",
          "CR",
          "CY",
          "CZ",
          "DE",
          "DK",
          "DO",
          "DZ",
          "EC",
          "EE",
          "EG",
          "ES",
          "FI",
          "FR",
          "GB",
          "GR",
          "GT",
          "HK",
          "HN",
          "HU",
          "ID",
          "IE",
          "IL",
          "IN",
          "IS",
          "IT",
          "JO",
          "JP",
          "KW",
          "LB",
          "LI",
          "LT",
          "LU",
          "LV",
          "MA",
          "MC",
          "MT",
          "MX",
          "MY",
          "NI",
          "NL",
          "NO",
          "NZ",
          "OM",
          "PA",
          "PE",
          "PH",
          "PL",
          "PS",
          "PT",
          "PY",
          "QA",
          "RO",
          "SA",
          "SE",
          "SG",
          "SK",
          "SV",
          "TH",
          "TN",
          "TR",
          "TW",
          "US",
          "UY",
          "VN",
          "ZA"
        ],
        "external_urls": {
          "spotify": "https://open.spotify.com/album/2BLLERMxO0aiUF7XTkKAse"
        },
        "href": "https://api.spotify.com/v1/albums/2BLLERMxO0aiUF7XTkKAse",
        "id": "2BLLERMxO0aiUF7XTkKAse",
        "images": [
          {
            "height": 640,
            "url": "https://i.scdn.co/image/ab67616d0000b27371dbccb7bec66093d7adbfac",
            "width": 640
          },
          {
            "height": 300,
            "url": "https://i.scdn.co/image/ab67616d00001e0271dbccb7bec66093d7adbfac",
            "width": 300
          },
          {
            "height": 64,
            "url": "https://i.scdn.co/image/ab67616d0000485171dbccb7bec66093d7adbfac",
            "width": 64
          }
        ],
        "name": "VULTURES CRY 2 (feat. WizDaWizard and Mike Smiff)",
        "release_date": "2020-06-11",
        "release_date_precision": "day",
        "total_tracks": 1,
        "type": "album",
        "uri": "spotify:album:2BLLERMxO0aiUF7XTkKAse"
      },
      {
        "album_type": "single",
        "artists": [
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/2tIP7SsRs7vjIcLrU85W8J"
            },
            "href": "https://api.spotify.com/v1/artists/2tIP7SsRs7vjIcLrU85W8J",
            "id": "2tIP7SsRs7vjIcLrU85W8J",
            "name": "The Kid LAROI",
            "type": "artist",
            "uri": "spotify:artist:2tIP7SsRs7vjIcLrU85W8J"
          },
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/4MCBfE4596Uoi2O4DtmEMz"
            },
            "href": "https://api.spotify.com/v1/artists/4MCBfE4596Uoi2O4DtmEMz",
            "id": "4MCBfE4596Uoi2O4DtmEMz",
            "name": "Juice WRLD",
            "type": "artist",
            "uri": "spotify:artist:4MCBfE4596Uoi2O4DtmEMz"
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
          "BH",
          "BO",
          "BR",
          "CA",
          "CH",
          "CL",
          "CO",
          "CR",
          "CY",
          "CZ",
          "DE",
          "DK",
          "DO",
          "DZ",
          "EC",
          "EE",
          "EG",
          "ES",
          "FI",
          "FR",
          "GB",
          "GR",
          "GT",
          "HK",
          "HN",
          "HU",
          "ID",
          "IE",
          "IL",
          "IN",
          "IS",
          "IT",
          "JO",
          "JP",
          "KW",
          "LB",
          "LI",
          "LT",
          "LU",
          "LV",
          "MA",
          "MC",
          "MT",
          "MX",
          "MY",
          "NI",
          "NL",
          "NO",
          "NZ",
          "OM",
          "PA",
          "PE",
          "PH",
          "PL",
          "PS",
          "PT",
          "PY",
          "QA",
          "RO",
          "SA",
          "SE",
          "SG",
          "SK",
          "SV",
          "TH",
          "TN",
          "TR",
          "TW",
          "US",
          "UY",
          "VN",
          "ZA"
        ],
        "external_urls": {
          "spotify": "https://open.spotify.com/album/40wtKuLVVlde1T88LqtZwa"
        },
        "href": "https://api.spotify.com/v1/albums/40wtKuLVVlde1T88LqtZwa",
        "id": "40wtKuLVVlde1T88LqtZwa",
        "images": [
          {
            "height": 640,
            "url": "https://i.scdn.co/image/ab67616d0000b273b44eea2092f7f4ba202f0764",
            "width": 640
          },
          {
            "height": 300,
            "url": "https://i.scdn.co/image/ab67616d00001e02b44eea2092f7f4ba202f0764",
            "width": 300
          },
          {
            "height": 64,
            "url": "https://i.scdn.co/image/ab67616d00004851b44eea2092f7f4ba202f0764",
            "width": 64
          }
        ],
        "name": "GO (feat. Juice WRLD)",
        "release_date": "2020-06-12",
        "release_date_precision": "day",
        "total_tracks": 1,
        "type": "album",
        "uri": "spotify:album:40wtKuLVVlde1T88LqtZwa"
      },
      {
        "album_type": "single",
        "artists": [
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/5vQfv3s2Z2SRdPZKr82ABw"
            },
            "href": "https://api.spotify.com/v1/artists/5vQfv3s2Z2SRdPZKr82ABw",
            "id": "5vQfv3s2Z2SRdPZKr82ABw",
            "name": "Dzeko",
            "type": "artist",
            "uri": "spotify:artist:5vQfv3s2Z2SRdPZKr82ABw"
          },
          {
            "external_urls": {
              "spotify": "https://open.spotify.com/artist/0u2FHSq3ln94y5Q57xazwf"
            },
            "href": "https://api.spotify.com/v1/artists/0u2FHSq3ln94y5Q57xazwf",
            "id": "0u2FHSq3ln94y5Q57xazwf",
            "name": "Keith Urban",
            "type": "artist",
            "uri": "spotify:artist:0u2FHSq3ln94y5Q57xazwf"
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
          "BH",
          "BO",
          "BR",
          "CA",
          "CH",
          "CL",
          "CO",
          "CR",
          "CY",
          "CZ",
          "DE",
          "DK",
          "DO",
          "DZ",
          "EC",
          "EE",
          "EG",
          "ES",
          "FI",
          "FR",
          "GB",
          "GR",
          "GT",
          "HK",
          "HN",
          "HU",
          "ID",
          "IE",
          "IL",
          "IN",
          "IS",
          "IT",
          "JO",
          "JP",
          "KW",
          "LB",
          "LI",
          "LT",
          "LU",
          "LV",
          "MA",
          "MC",
          "MT",
          "MX",
          "MY",
          "NI",
          "NL",
          "NO",
          "NZ",
          "OM",
          "PA",
          "PE",
          "PH",
          "PL",
          "PS",
          "PT",
          "PY",
          "QA",
          "RO",
          "SA",
          "SE",
          "SG",
          "SK",
          "SV",
          "TH",
          "TN",
          "TR",
          "TW",
          "US",
          "UY",
          "VN",
          "ZA"
        ],
        "external_urls": {
          "spotify": "https://open.spotify.com/album/5vlZ9FpvZqIkOkXuqTHnLJ"
        },
        "href": "https://api.spotify.com/v1/albums/5vlZ9FpvZqIkOkXuqTHnLJ",
        "id": "5vlZ9FpvZqIkOkXuqTHnLJ",
        "images": [
          {
            "height": 640,
            "url": "https://i.scdn.co/image/ab67616d0000b2737aee948598b3d9b401a2a5a4",
            "width": 640
          },
          {
            "height": 300,
            "url": "https://i.scdn.co/image/ab67616d00001e027aee948598b3d9b401a2a5a4",
            "width": 300
          },
          {
            "height": 64,
            "url": "https://i.scdn.co/image/ab67616d000048517aee948598b3d9b401a2a5a4",
            "width": 64
          }
        ],
        "name": "Both Still Young",
        "release_date": "2020-06-05",
        "release_date_precision": "day",
        "total_tracks": 1,
        "type": "album",
        "uri": "spotify:album:5vlZ9FpvZqIkOkXuqTHnLJ"
      }
    ],
    "limit": 10,
    "next": "https://api.spotify.com/v1/browse/new-releases?country=CA&offset=10&limit=10",
    "offset": 0,
    "previous": null,
    "total": 100
  }
}






