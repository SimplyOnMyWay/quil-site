(ns quil-site.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [site]]
            [compojure.route :refer [files]]
            [ring.util.response :as resp]
            [ring.middleware.json :as json]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.stacktrace :as stacktrace]
            [quil-site.views.about :refer [about-page]]
            [quil-site.views.shows :refer [shows-page]]
            [quil-site.views.interviews :refer [interviews-page]]))

(defroutes app
  (GET "/" [] (about-page))
  (GET "/shows" [] (shows-page))
  (GET "/interviews" [] (interviews-page))
  (GET "/favicon.ico" [] {:status 204})
;  (files "/out-main" {:root "out-main"})
;  (files "/out-editor" {:root "out-editor"})
;  (files "/out-preload" {:root "out-preload"})
;  (files "/out-snippets" {:root "out-snippets"})
  (files "/")
  )

(def handler
  (-> #'app
      site
      (json/wrap-json-body {:keywords? true})
      json/wrap-json-response
      stacktrace/wrap-stacktrace))

(defn run [port]
  (run-jetty handler {:port (Integer/parseInt port)}))

