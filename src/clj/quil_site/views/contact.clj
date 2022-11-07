(ns quil-site.views.contact
  (:require [quil-site.views.page :refer [page]]
            [hiccup.element :refer [link-to]]))


(defn contact-page []
  (page {:tab :contact
         :type :contact
         :js-files ["/js/contact-app.js"]
         :title "Contact!"
         :css-files ["/css/contact-styles.css"]}
        [:section {:class "section"}
         [:div {:class "container"}
          [:div {:class "box"}
           [:div {:class "columns"}
            [:div {:class "column"}
             [:div {:class "content"}


              (comment
                [:div {:class "form-container"}
                 [:form {:class "contact-form"}
                  [:h2 "Contact"]
                  [:input {:type "text" :id "name" :placeholder "Full name"}]
                  [:br]
                  [:input {:type "email" :id "email" :placeholder "Email"}]
                  [:br]
                  [:input {:type "text" :id "subject" :placeholder "Subject"}]
                  [:br]
                  [:textarea {:id "message" :placeholder "message" :cols "30" :rows "10"}]
                  [:br]
                  [:input {:type "submit" :class "submit" :value "Send Message"}]]])

              [:p "Email: micheal [at] michealocathain.com"]
              [:br]
              [:p "Connect via social media:"]
              [:p {}
               [:a {:href "https://www.instagram.com/simplyonmyway/"} [:img {:class "alignnone ", :src "../img/instagram-icon.png", :width "5%"}]]
               [:a {:href "https://www.facebook.com/michealocathainharpvoice"} [:img {:class "alignnone ", :src "../img/facebook-icon.png", :width "5.5%"}]]]

              [:br]
              [:p
               [:a {:href "https://linktr.ee/simplyonmyway"} "Linktree"]]
              ]]]]]]))

