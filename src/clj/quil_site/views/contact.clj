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
              [:p "Contact form coming soon!"]
              [:p "For now please get in touch via social media:"]
              [:p {}
               [:a {:href "https://www.instagram.com/simplyonmyway/"} [:img {:class "alignnone ", :src "../img/instagram-icon.png", :width "5%"}]]
               [:a {:href "https://www.facebook.com/michealocathainharpvoice"} [:img {:class "alignnone ", :src "../img/facebook-icon.png", :width "5.5%"}]]]]]]]]]))

