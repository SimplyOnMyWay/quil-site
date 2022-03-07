(ns quil-site.views.ab
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))

(defn ab-page []
  (page {:tab :ab
         :type :ab-page
         :js-files ["/js/main.js"]
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
              [:h3 {} [:strong {} "[Placeholder]"]]
              [:p {} "This is a placeholder URL for my March 2022 application to Art Blocks.  Working protype will be hosted here in the coming days, consisting:"]
        [:ul {}
         [:li {} "" [:a {:href ""} "rendered artwork"]]
         [:li {} "" [:a {:href ""} "p5.js script, unminified"]]
         [:li {} [:a {:href ""} "p5.js script, minified"]]
]
              [:p {} [:strong {} " - Mícheál Ó Catháin 07.03.2022"]]
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


