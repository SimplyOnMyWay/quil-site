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
               [:li {} "" [:a {:href ""} "rendered artwork."] " Scroll down and reload page to generate a fresh iteration!"]
               [:li {} "" [:a {:href "cljs/dynamic.cljs"} "clojurescript code. "] "I normally make generative art in clojurescript.  I love this language and how well suited it is for generative art."]
               [:li {} "" [:a {:href "js/moc-ab-script.js"} "p5.js script, unminified. "] "For Art Blocks I port from clojurescript to google closure compatible javascript."]
               [:li {} [:a {:href "js/moc-ab-script-compiled-a.js"} "p5.js script, minified. "] "I minify my javascript code using the google closure compiler."]
               ]

              [:br]
              [:p  [:a {:href "/ab/artist-statement"} "Artist statement"] " here"]
              [:p {} "Please be aware that generative audio is currently in progress and not yet included in this prototype.  A generative system of audio based on synthesis of my early Gaelic harp, as well as sythesised vocal suitable for minified on-chain code is currently my main focus. This prototype will be updated soon to include this generative audio."]
            
              [:p {} [:strong {} " - Mícheál Ó Catháin"]]
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
            [:p "yo!"]
            [:span.glyphicon.glyphicon-pause.hidden.pause]]]]]))


