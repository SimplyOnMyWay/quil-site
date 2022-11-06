(ns quil-site.views.luthchleasa-documentation
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn luthchleasa-documentation-page []
  (page {:tab :luthchleasa-documentation
         :type :luthchleasa-documentation-page
         :js-files ["/js/main.js"]
         :title "Photo documentation of Lúthchleasa @ Galway Arts Centre"}

        [:div.section
         [:p.lead
          ""]]

        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "content"}
            [:div {:class "columns"}

             [:h2 {} [:strong {} "Video and photo documentation of "]]
             [:h2 {} [:strong {} "Lúthchleasa [lu:hxlˈæsə]"]]
             [:h2 {} [:strong {} "@ Galway Arts Centre / December 2021"]]
             ;; toc at top of page with links to sections...
             [:a {:href "#vi"} "Video"]
             [:br]
             [:a {:href "#pu"} "Publicity"]             
             [:br]
             [:a {:href "#ga"} "Gallery Photos"]
             [:br]
             [:a {:href "#fr"} "Framed Work"]
             [:br]
             [:a {:href "#wl"} "Works List"]
             [:br]
                          
             [:div {:class "column" :id "vi"}
              [:h3 {} [:strong {} "Video"]]
              ;; Mini-film
              [:p {}  "Click play and select fullscreen to view video (4min):"]
              [:div {:style="padding:56.25% 0 0 0;position:relative;"}
               [:iframe {:src "https://player.vimeo.com/video/662073256?h=a1efa9580f&amp;badge=0&amp;autopause=0&amp;player_id=0&amp;app_id=58479" :allowfullscreen "allowfullscreen" :allowfullscreenstyle "position:absolute;top:0;left:0;width:100%;height:100%;" :title "L&amp;uacute;thchleasa Solo Exhibition @ Galway Arts Centre /// December 2021" :width "480" :height "270"  :frameborder "0"
                         }]]
              ;; :allow "autoplay; fullscreen; picture-in-picture"
              [:script {:src "https://player.vimeo.com/api/player.js"}]]


             [:div {:class "column" :id "pu"}
              [:h3 {} [:strong {} "Publicity:"]]
              [:p [:a {:href "https://www.galwayartscentre.ie/exhibitions/382-luthchleasa-lu-hxl-aes-by-micheal-o-cathain?lang=en"}"Artist Statement & Bio"]]
              [:p [:a {:href "../img/art/luthchleasa_documentation/Luthchleasa-GAC-2021-Gallery-Text.pdf"}"Gallery Text"]]
              [:p [:a {:href "https://www.galwaydaily.com/arts-entertainment/galway-arts-centre-announces-december-programme/"}"Galway Daily, 04.12.2021"]]
              [:p [:a {:href "https://www.advertiser.ie/galway/article/126241/three-exhibitions-open-today-at-galway-arts-centre"}"Galway Advertiser, 08.12.2021"]]
              [:p [:a {:href "https://connachttribune.ie/east-and-west-meet-in-arts-centre-exhibitions/"} "Connacht Tribune, 10.12.2021"]]
              [:br]]
             
             [:div {:class "column" :id "ga"}
              [:h3 {} [:strong {} "Gallery Photos"]]
              [:p {}  "Click on each thumbnail for a high resolution image:"]
              ;;     [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_2.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_2.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_5.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_5.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_9.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_9.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_14.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_14.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_17.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_17.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_20.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_20.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_20.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_23.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_25.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_25.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_28.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_28.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_33.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_33.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_36.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_36.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_38.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_38.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_43.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_43.jpg", :width "20%"}]]
              [:br]
              [:br]                            
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_46.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_46.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_48.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_48.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_52.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_52.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_54.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_54.jpg", :width "20%"}]]
              [:br]
              [:br]
              [:a {:href "../img/art/luthchleasa_documentation/luthchleasa_56.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa_documentation/scaled/luthchleasa_56.jpg", :width "20%"}]]

              [:br]
              [:p "(Photographer: Tom Flanagan)"]
              [:br]]

             ;; framed work
             [:div {:class "column" :id "fr"}
              [:h3 {} [ :strong {} "Framed Work (October 2022)"]]
              [:p {}  "Click on each thumbnail for a high resolution image:"]
              [:a {:href "../img/art/luthchleasa_documentation/luis-1-standard-c.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luis-1-standard-c-1000x1000.jpg", :width "20%"}]]
              [:a {:href "../img/art/luthchleasa_documentation/luis-1-left.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luis-1-left-1000x1000.jpg", :width "20%"}]]
              [:a {:href "../img/art/luthchleasa_documentation/luis-1-tl.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luis-1-tl-1000x1000.jpg", :width "20%"}]]

              [:br]
              [:br]
              [:br]                            

              [:a {:href "../img/art/luthchleasa_documentation/luis-2-left.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luis-2-left-1000x1000.jpg", :width "20%"}]]
              [:a {:href "../img/art/luthchleasa_documentation/luis-2-standard-b.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luis-2-standard-b-1000x1000.jpg", :width "20%"}]]
              [:a {:href "../img/art/luthchleasa_documentation/luis-2-br.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luis-2-br-1000x1000.jpg", :width "20%"}]]

              [:br]
              [:br]
              [:br]
              
              [:a {:href "../img/art/luthchleasa_documentation/luis-5-br.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luis-5-tr-1000x1000.jpg", :width "20%"}]]
              [:a {:href "../img/art/luthchleasa_documentation/luis-5-left.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luis-5-left-1000x1000.jpg", :width "20%"}]]
              [:a {:href "../img/art/luthchleasa_documentation/luis-5-standard-f.jpg"} [:img {:class "hormargins", :src "../img/art/luthchleasa_documentation/scaled/luis-5-standard-f-1000x1000.jpg", :width "20%"}]]

              [:br]
              [:br]
              [:br]]

             [:div {:class "column" :id "wl"}
              [:h3 {} [ :strong {} "Works List"]]
              [:h4 {} [:strong {} "Beith Series"]]
              [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with deckled edge"]]
              [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/beith-01-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/beith-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Barrlúth"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm (unframed)" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P (unframed)"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/beith-02-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/beith-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Barrlúth oscailte II"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/beith-03-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/beith-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Barrlúth oscailte I"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]
              [:br]
              [:br]
              
              [:h4 {} [:strong {} "Coll Series"]]
              [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with deckled edge"]]
              [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/coll-01-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/coll-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Cúl aithris I"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/coll-02-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/coll-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Caslúth"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/coll-03-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/coll-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Cúl aithris II"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]
              [:br]
              [:br]
                            
              [:h4 {} [:strong {} "Fearn Series"]]
              [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with straight edge"]]
              [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
              [:p {} "The prints for the Fearn series have dimensions 141 x 121 mm, identical to the paper Bunting used in his field collecting of the old music from Irish harpers in the period 1792 - ca. 1805."]
              [:p {} "Four " [:em "lúthchleasa"] " are represented in the Fearn series:"]
              [:ul
               [:li {} [:em "Leagadh anuas"] " , translated from Gaelic to English as \"falling/knocked down from above\". Four prints."]
               [:li {} [:em "Leath leagadh"] " , translated as \"half-falling\". Three prints."]
               [:li {} [:em "Brisidh"] " , translated as 'a break'. Six prints"]
               [:li {} [:em "Crothach aon mhéar"] " , translated as 'one finger shaking'. Two prints"]]
              [:br]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-01-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leagadh anuas I"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-02-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leagadh anuas II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-03-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leath leagadh I"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-04-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-04-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leagadh anuas III"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-05-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-05-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leath leagagh II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-06-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-06-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh I"]]
                [:span {:style "font-size:9px"} [:br] "141x121m" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-07-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-07-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]

              [:br]
              [:br]
              
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-08-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-08-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Crothach aon mhéar I"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-09-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-09-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leagadh anuas IV"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-10-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-10-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh III"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-11-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-11-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh IV"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-12-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-12-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Leath leagadh III"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-13-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-13-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:12px"} [:em "Crothach aon mhéar II"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-14-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-14-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh V"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]
              [:figure {:class "hormarginstight" :style "width:10%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/fearn-15-1000x1000.jpg"}
                [:img {:class "hormarginstight" :src "../img/art/luthchleasa/fearn-15-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Brisidh VI"]]
                [:span {:style "font-size:9px"} [:br] "141x121mm" [:br] "2021" [:br] "1/1" [:br] "€95 + P&P"]]]              
              [:br]
              [:br]
              
              [:h4 {} [:strong {} "Luis Series"]]
              [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with deckled edge"]]
              [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/luis-01-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/luis-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Taobhchrobh"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "SOLD"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/luis-02-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/luis-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Ceann an chruibh I"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/luis-03-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/luis-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Lánchrobh"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]
              [:br]
              [:br]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/luis-04-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/luis-04-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Ceann an chruibh II"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "SOLD"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/luis-05-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/luis-05-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Glaslúth"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "SOLD"]]]              
              [:br]
              [:br]
              
              [:h4 {} [:strong {} "Sail Series"]]
              [:p {} [:strong {} "Digital archival prints on Hahnemühle Museum Etching paper, with deckled edge"]]
              [:p {}  "Frame visualisation is indicative only. Dimensions and prices unframed. Click on each thumbnail for a higher resolution image of the artwork."]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/sail-01-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/sail-01-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Sruth beag I"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/sail-02-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/sail-02-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Sruth beag II"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]                        [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/sail-03-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/sail-03-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Suas éirí"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]
              [:br]
              [:br]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/sail-04-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/sail-04-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Sruth mór suas"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]
              [:figure {:class "hormargins" :style "width:30%;display:inline-block;"}
               [:a {:href "../img/art/luthchleasa/sail-05-1000x1000.jpg"}
                [:img {:class "hormargins" :src "../img/art/luthchleasa/sail-05-thumbnail-framed.png" :width "100%"}]]
               [:figcaption {:style "text-align:center;"} ]
               [:figcaption {:style "text-align:center"}
                [:span {:style "font-size:13px"} [:em "Sruth mór síos"]]
                [:span {:style "font-size:9px"} [:br] "400x400mm" [:br] "2021" [:br] "1/1" [:br] "€415 + P&P"]]]

              [:br]
              [:br]

              ]
             

             ]]]]]))


