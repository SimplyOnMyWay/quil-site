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

             [:div {:class "column"}
              [:h2 {} [:strong {} "Video and photo documentation of Lúthchleasa @ Galway Arts Centre"]]
              ;;[:h2 {} [:strong {} "Video Documentation (4min)"]]
              [:br]
              [:br]
              [:p {}  "Click play and select fullscreen to view video (4min):"]
              [:div {:style="padding:56.25% 0 0 0;position:relative;"}
               [:iframe {:src "https://player.vimeo.com/video/662073256?h=a1efa9580f&amp;badge=0&amp;autopause=0&amp;player_id=0&amp;app_id=58479" :allowfullscreen "allowfullscreen" :allowfullscreenstyle "position:absolute;top:0;left:0;width:100%;height:100%;" :title "L&amp;uacute;thchleasa Solo Exhibition @ Galway Arts Centre /// December 2021" :width "480" :height "270"  :frameborder "0"
                         }]]
              ;; :allow "autoplay; fullscreen; picture-in-picture"
              [:script {:src "https://player.vimeo.com/api/player.js"}]
              [:br]
              [:br]              
              ;;[:h2 {} [:strong {} "Photo Documentation"]]
              [:p {}  "Click on each thumbnail for higher resolution image:"]
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
              [:br]

    






              ]]]]]





         [:div.row.examples
          [:div#template {:class "col-md-4 col-sm-6 col-xs-12 hidden"}
           [:div.example
            [:div.name]
            [:div.author]
            [:div.canvas-container
             "here"
             [:div.play.hidden]]
            [:div.footer
             [:span.glyphicon.glyphicon-sort.hidden
              {:data-toggle "tooltip"
               :data-placement "bottom"
               :title (str "Interactive. Select to start interacting using "
                           "mouse/keyboard.")}]
             [:a "source"]
             [:span.glyphicon.glyphicon-pause.hidden.pause]]]]]]))


