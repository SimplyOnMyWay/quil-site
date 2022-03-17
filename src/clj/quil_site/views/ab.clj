(ns quil-site.views.ab
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]
            [hiccup.page :refer [include-js]]))

;(include-js "https://cdn.jsdelivr.net/npm/p5@1.0.0/lib/p5.js")

(defn ab-page []
  (page {:tab :ab
         :type :ab-page
         :js-files ["https://cdn.jsdelivr.net/npm/p5@1.0.0/lib/p5.js" "js/ab_hash.js" "js/moc-ab-script-compiled-a.js"]
         :title "Art Blocks working prototype"}

        [:div.section
         [:p.lead
          "Art Blocks working prototype"]]

        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "content"}
            [:div {:class "columns"}

             [:div {:class "column"}
              [:p {} "Hello! Here is my working prototype as part of my debut application to Art Blocks, submitted March 2022."]
              [:p {} "This evolving work in progress consists:"]
              [:ul {}
               [:li {} "" [:a {:href ""} "rendered artwork"]]
               [:li {} "" [:a {:href "js/moc-ab-script.js"} "p5.js script, unminified"]]
               [:li {} [:a {:href "js/moc-ab-script-compiled-a.js"} "p5.js script, minified"]]
               ]
              [:p {} [:strong {} " - Mícheál Ó Catháin 09.03.2022"]]
              ]]]]]]





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


