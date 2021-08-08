(ns quil-site.views.contact
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn contact-page []
  (page {:tab :contact
         :type :contact
         :js-files ["/js/main.js"]
         :title "Contact!"}
        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "columns"}
            [:div {:class "column"}
             [:div {:class "content"}
              [:h2 "Contact"]
              [:p "get in touch..."]]]]]]]))

