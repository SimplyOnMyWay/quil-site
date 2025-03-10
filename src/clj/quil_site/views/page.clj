(ns quil-site.views.page
  (:require [hiccup.page :as p]
            [hiccup.element :as e]))

(defn- head [opts]
  [:head
   [:meta {:charset "utf-8"}]
   [:meta {:http-equiv "X-UA-Compatible"
           :content "IE=edge"}]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]

   [:title (or (:title opts) "Micheal O'Cathain")]

   (comment
     [:script {:async "async"
               :src "//www.google-analytics.com/analytics.js"}]
     [:script
      "(function(i,s,r){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();
  })(window,document,'ga');

  ga('create', 'UA-51485241-2', {'siteSpeedSampleRate': 100});
  ga('send', 'pageview');
  window.onerror = function(message) {
    ga('send', 'exception', {
      exDescription: message,
      exFatal: false
    });
  };"])

   (let [css-files (conj (:css-files opts [])
                         "/css/bootstrap.min.css"
                         "/css/styles.css")]
     (apply p/include-css css-files))])

;;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; this one is for static tabs!!
;;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn- make-tab [opts name text url]
  [:li {:class (if (= name (:tab opts))
                 "active" "")}
   (e/link-to url text)])

(defn- body [opts content]
  [:body
   [:div.navbar.navbar-default {:role "navigation"}
    [:div.container
     [:div.navbar-header
      [:button.navbar-toggle {:type "button"
                              :data-toggle "collapse"
                              :data-target ".navbar-collapse"}
       [:span.sr-only "Toggle navigation"]
       [:span.icon-bar]
       [:span.icon-bar]
       [:span.icon-bar]]
      [:a.navbar-brand {:href "/"} "Mícheál Ó Catháin"]]

     [:div.collapse.navbar-collapse
      [:ul.nav.navbar-nav {:class "nav nav-tabs navbar-right"}
       (make-tab opts :about "About" "/about")
       (make-tab opts :shows "Shows" "/shows")
       (make-tab opts :interviews "Interviews" "/interviews")
       (make-tab opts :contact "Projects" "/projects")       
       (make-tab opts :contact "Contact" "/contact")
       ]]]]

   [:div {:class (str (-> opts :type (or "") name)
                      " "
                      (:container-class opts "container"))}
    content]

   (let [js-files (concat ["//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"
                           "/js/bootstrap.min.js"]
                          (:js-files opts []))]
     (apply p/include-js js-files))])

(defn page [opts & content]
  (p/html5 {:lang "en"}
           (list (head opts)
                 (body opts content))))
