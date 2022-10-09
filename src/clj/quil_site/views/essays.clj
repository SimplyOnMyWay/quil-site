(ns quil-site.views.essays
  (:require [quil-site.views.page :refer [page]]))

(defn essays-page []
  (page {:tab :essays
         :type :essays
         :js-files []
         :title "Essays"}

        [:div.section
         [:p.lead
          (comment          "Why I make generative audio visual art ")]]

        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "content"}
            [:div {:class "columns"}

             (comment
               [:a {:href "#intro"} "Introduction"]
               [:br]
               [:a {:href "#s1"} "Section 1...."])
             
             [:div {:class "column" :id "as"}
              [:h2 {} "Essays"]
              [:ol
               [:li [:a {:href "https://michealocathain.com/essay-why-I-make-lfgav-art"} "Why I make generative audiovisual art"]]
               [:li [:a {:href "https://michealocathain.com/essay-why-I-combine-IRL-and-digital"} "The benefit to my voice and harp practice of combining analogue and digital audiovisuals"]]
               [:li [:a {:href "https://michealocathain.com/essay-the-role-of-live-performance-in-how-I-make-av-art"} "The role of live performance in how I make audiovisual art"]]]]]]]]]))
