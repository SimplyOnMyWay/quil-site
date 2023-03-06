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
 ;           [quil-site.views.simon-chadwick :refer [simon-chadwick-page]]
            [quil-site.views.siobhan-armstrong :refer [siobhan-armstrong-page]]
            [quil-site.views.projects :refer [projects-page]]
            [quil-site.views.luthchleasa :refer [luthchleasa-page]]
            [quil-site.views.luthchleasa-documentation :refer [luthchleasa-documentation-page]]
            [quil-site.views.ab :refer [ab-page]]
            [quil-site.views.ab-as :refer [ab-as-page]]
            [quil-site.views.artblocks-juxt :refer [artblocks-juxt-page]]
            [quil-site.views.photobook :refer [photobook-page]]            
            [quil-site.views.essays :refer [essays-page]]
            [quil-site.views.essay-why-I-make-lfgav-art :refer [essay-why-I-make-lfgav-art-page]]
            [quil-site.views.essay-why-I-combine-IRL-and-digital-voice-and-harp-av :refer [essay-why-I-combine-IRL-and-digital-voice-and-harp-av-page]]
            [quil-site.views.essay-the-role-of-live-performance-in-how-I-make-av-art :refer [essay-the-role-of-live-performance-in-how-I-make-av-art-page]]
            [quil-site.views.essay-thoughts-on-tokenising-my-generative-audiovisual-art :refer [essay-thoughts-on-tokenising-my-generative-audiovisual-art-page]]
            [quil-site.views.contact :refer [contact-page]]
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
;  (GET "/interviews/simon-chadwick" [] (simon-chadwick-page))
  (GET "/interviews/siobhan-armstrong" [] (siobhan-armstrong-page))
  (GET "/projects" [] (projects-page))
  (GET "/luthchleasa" [] (luthchleasa-page))
  (GET "/luthchleasa-documentation" [] (luthchleasa-documentation-page))
  (GET "/ab" [] (ab-page))
  (GET "/ab/artist-statement" [] (ab-as-page))
  (GET "/artblocks-juxt" [] (artblocks-juxt-page))
  (GET "/photobook" [] (photobook-page))    
  (GET "/essays" [] (essays-page))
  (GET "/essay-why-I-make-lfgav-art" [] (essay-why-I-make-lfgav-art-page))
  (GET "/essay-why-I-combine-IRL-and-digital" [] (essay-why-I-combine-IRL-and-digital-voice-and-harp-av-page))
  (GET "/essay-the-role-of-live-performance-in-how-I-make-av-art" [] (essay-the-role-of-live-performance-in-how-I-make-av-art-page))
  (GET "/essay-thoughts-on-tokenising-my-generative-audiovisual-art" [] (essay-thoughts-on-tokenising-my-generative-audiovisual-art-page))
  (GET "/contact" [] (contact-page))
  (GET "/contact-post" [] (contact-page))
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


