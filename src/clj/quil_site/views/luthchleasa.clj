(ns quil-site.views.luthchleasa
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn luthchleasa-page []
  (page {:tab :luthchleasa
         :type :luthchleasa-page
         :js-files ["/js/main.js"]
         :title "Lúthchleasa Showcase"}

        [:div.section
         [:p.lead
          "Lúthchleasa Showcase"]]

        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "content"}
            [:div {:class "columns"}

             [:div {:class "column"}
              [:h3 {} [:strong {} "Beith Series"]]
              [:p {} [:strong {} "400x400mm deckled"]]
              [:p {} [:strong {} "Further details (titles, medium, number of editions, dates, price etc) TBA"]]
              [:p {}  "Click on each thumbnail for higher resolution image."]
              [:a {:href "../img/art/luthchleasa/beith-01-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/beith-01-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/beith-02-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/beith-02-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/beith-03-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/beith-03-1000x1000.jpg", :width "200"}]]


              [:h3 {} [:strong {} "Coll Series"]]
              [:p {} [:strong {} "400x400mm deckled"]]
              [:p {} [:strong {} "Further details (titles, medium, number of editions, dates, price etc) TBA"]]
              [:p {}  "Click on each thumbnail for higher resolution image."]
              [:a {:href "../img/art/luthchleasa/coll-01-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/coll-01-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/coll-02-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/coll-02-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/coll-03-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/coll-03-1000x1000.jpg", :width "200"}]]


              [:h3 {} [:strong {} "Fearn Series"]]
              [:p {} [:strong {} "141x121mm"]]
              [:p {} [:strong {} "Further details (titles, medium, number of editions, dates, price etc) TBA"]]
              [:p {}  "Click on each thumbnail for higher resolution image."]
              [:a {:href "../img/art/luthchleasa/fearn-01-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-01-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-02-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-02-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-03-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-03-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-04-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-04-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-05-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-05-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-06-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-06-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-07-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-07-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-08-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-08-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-09-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-09-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-10-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-10-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-11-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-11-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-12-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-12-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-13-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-13-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-14-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-14-1000x1000.jpg", :width "100"}]]
              [:a {:href "../img/art/luthchleasa/fearn-15-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/fearn-15-1000x1000.jpg", :width "100"}]]
              
              
              [:h3 {} [:strong {} "Luis Series"]]
              [:p {} [:strong {} "400x400mm deckled"]]
              [:p {} [:strong {} "Further details (titles, medium, number of editions, dates, price etc) TBA"]]
              [:p {}  "Click on each thumbnail for higher resolution image."]
              [:a {:href "../img/art/luthchleasa/luis-01-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/luis-01-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/luis-02-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/luis-02-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/luis-03-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/luis-03-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/luis-04-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/luis-04-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/luis-05-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/luis-05-1000x1000.jpg", :width "200"}]]



              [:h3 {} [:strong {} "Sail Series"]]
              [:p {} [:strong {} "400x400mm deckled"]]
              [:p {} [:strong {} "Further details (titles, medium, number of editions, dates, price etc) TBA"]]
              [:p {}  "Click on each thumbnail for higher resolution image."]
              [:a {:href "../img/art/luthchleasa/sail-01-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/sail-01-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/sail-02-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/sail-02-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/sail-03-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/sail-03-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/sail-04-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/sail-04-1000x1000.jpg", :width "200"}]]
              [:a {:href "../img/art/luthchleasa/sail-05-1000x1000.jpg"} [:img {:class "alignnone ", :src "../img/art/luthchleasa/sail
-05-1000x1000.jpg", :width "200"}]]

              ]


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
            [:span.glyphicon.glyphicon-pause.hidden.pause]]]]]))


