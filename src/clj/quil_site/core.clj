(ns quil-site.core
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.handler :refer [site]]
            [compojure.route :refer [files]]
            [compojure.middleware :refer [remove-trailing-slash wrap-canonical-redirect]]
            [ring.util.response :as resp]
            [ring.middleware.json :as json]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.stacktrace :as stacktrace]
            [quil-site.views.home :refer [home-page]]
            [quil-site.views.about :refer [about-page]]
            [quil-site.views.shows :refer [shows-page]]
            [quil-site.views.interviews :refer [interviews-page]]
            [quil-site.views.ann-heymann-1 :refer [ann-heymann-1-page]]
            [quil-site.views.ann-heymann-2 :refer [ann-heymann-2-page]]
            [quil-site.views.paul-dooley :refer [paul-dooley-page]]
            [quil-site.views.javier-sainz :refer [javier-sainz-page]]
            [quil-site.views.simon-chadwick :refer [simon-chadwick-page]]
            [quil-site.views.siobhan-armstrong :refer [siobhan-armstrong-page]]
            [quil-site.views.projects :refer [projects-page]]
            [quil-site.views.luthchleasa :refer [luthchleasa-page]]
            ;;[quil-site.views.contact :refer [contact-page]]
            )
  (:gen-class))

(defroutes app
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/shows" [] (shows-page))
  (GET "/interviews" [] (interviews-page))
  (GET "/interviews/ann-heymann-1" [] (ann-heymann-1-page))
  (GET "/interviews/ann-heymann-2" [] (ann-heymann-2-page))
  (GET "/interviews/paul-dooley" [] (paul-dooley-page))
  (GET "/interviews/javier-sainz" [] (javier-sainz-page))
  (GET "/interviews/simon-chadwick" [] (simon-chadwick-page))
  (GET "/interviews/siobhan-armstrong" [] (siobhan-armstrong-page))
  (GET "/projects" [] (projects-page))
  (GET "/luthchleasa" [] (luthchleasa-page))
  ;;  (GET "/contact" [] (contact-page))
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

(defn remove-trailing-slash-except-root
  "fix remove-trailing-slash so it doesn't remove slash at root"
  [^String uri]
  (if (not= uri "/")
    (remove-trailing-slash uri)
    uri))

(defn -main []
  (run-jetty (wrap-canonical-redirect handler remove-trailing-slash-except-root) {:port (Integer/parseInt "5331")}))

;(-main)

