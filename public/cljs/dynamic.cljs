(ns simplyonmyway.dynamic
  (:require
   [quil.core :as q :include-macros true]
   [simplyonmyway.randomutils :as r]))

(defn w
  ([val] (* (q/width) val))
  ([] (* (w 1.0))))

(defn h
  ([val] (* (q/height) val))
  ([] (* (h 1.0))))

(defn hw
  [p]
  [(w (p 0)) (h (p 1))])

(def R (new r/random))

(defn gauss
  ([mean sd]
   (.random_gaussian R mean sd))
  ([]
   (gauss 0 1)))

(defn random-int
  ([l u]
   (.random_int R l u))
  ([u]
   (.random_int R 0 u)))

(defn pareto
 [l u shape]
  (.random_pareto_bounded R l u shape))

(def phi (/ (+ 1 (.sqrt js/Math 5)) 2)) ;;golden ratio

(def PI (.-PI js/Math))

(defn log-x-y
  "return log of y with base x"
  [x y]
  (/ (.log js/Math y) (.log js/Math x)))

(defn golden-spiral-theta
  "returns theta polar coordinate given r"
  [r]
  (* (/ PI 2) (log-x-y phi r)))

(defn golden-spiral-r
  "returns theta polar coordinate given r"
  ([theta]
   (golden-spiral-r phi theta))
  ([base theta]
   (.pow js/Math base (/ (* 2 theta) PI)))) 

(comment)
(defn as-cartesian-my
  [r theta]
  [(* r (.cos js/Math theta)) (* r (.sin js/Math theta))])

(defn as-cartesian
  [r theta]
  (let [b (js/Float32Array. 2)]
    (aset b 0 (double (* r (Math/cos theta))))
    (aset b 1 (double (* r (Math/sin theta))))
    b))

(defn gen-spiral-xy-vector
  [base start-angle end-angle number-vertices]
  (let [step (/ (- end-angle start-angle) number-vertices)
        theta-vector (into [] (range start-angle (+ end-angle step) step))
        base-vector (into [] (repeat (count theta-vector) base))
        r-vector (mapv #(golden-spiral-r %1 %2) base-vector theta-vector)
        spiral-r-theta-vector (mapv #(identity [%1 %2])  r-vector theta-vector)
        spiral-xy-vector (mapv #(apply as-cartesian %) spiral-r-theta-vector)]
    spiral-xy-vector))

(defn draw-spiral
  ([sp vertex-sd scale x-mean y-mean x-sd y-sd]
   (let [x (+ x-mean (gauss 0 x-sd))
         y (+ y-mean (gauss 0 y-sd))]
     (q/with-translation [(w x) (h y)]
       (q/begin-shape)
       (doseq [_ (range (count sp))]
         (apply q/vertex (hw (mapv #(/ (gauss % vertex-sd) scale) (sp _)))))
       (q/end-shape))))
  ([sp vertex-sd scale]
   (draw-spiral sp vertex-sd scale 0.5 0.5 0.0 0.0)))

(def col-vec-mess
  [[0 79 0 0.1] [354 48 0 0.1]])

(defn setup
  []
  (q/color-mode :hsb 360 100 100 1.0))

(defn update-state
  [state])

(defn draw
  [state]
  (q/no-loop)
  (q/no-fill)
;  (def bg-col [0 0 100 1.0]) 
;  (def bg-col [253 45 85 1.0])
  (def bg-col-vec [[48 42 27 1.0]
                   [208 25 95]]) ; default = Rosc moss
;  (def s-col [7 95 80 0.68])  ; default = Rosc rose with a=0.68
;;  (def s-col [208 25 95 1.0])
  (def alpha 0.68)
  (def s-col-vec [[[208 65 74 alpha]
                   [107 60 45 alpha]
                   [79 83 74 alpha]
                   [0 76 94 alpha]]
                  [[265 80 75 alpha]
                   [253 45 85 alpha]
                   [33 47 65 alpha]]])
;;; defaults...
  (def number-vertices 1500)
  (def no-iter 3)
  (def start-angle-vec (into [0 0 0] (map #(* -1 PI %) (range 0.0 10 0.5))))
  (def end-angle-vec (into [] (map #(* 1 PI %) (range 1.0 3.0 0.125))))
  (def palette-no (random-int 1))


  (apply q/background (bg-col-vec palette-no))

  
  (println "end-angle-vec = " end-angle-vec)

  ;;(def scale 20)
  ;;(def vertex-sd 0.01)
  ;;(def spiral-step 0.05)
  ;;(apply q/stroke s-col)
  ;;(q/stroke-weight (w 0.001))

  (comment
    x-sd (let [x-sd-vec [0 (pareto 0.01 2 0.1)]]
           (x-sd-vec (random-int (dec (count x-sd-vec)))))
    y-sd (let [y-sd-vec [0 (/ x-sd 10) x-sd]]
           (y-sd-vec (random-int (dec (count y-sd-vec))))))

  (doseq [_ (range no-iter)]
    (let [x-mean
          (let [x-mean-vec (reduce into []
                            [(repeat 15 0.5)
                             (repeat 1 (- phi 1.0))
                             (repeat 2 (- 2 phi))])]
            (x-mean-vec (random-int (dec (count x-mean-vec)))))
          y-mean
          (let [y-mean-vec (reduce into []
                            [(repeat 8 0.5)
                             (repeat 7 x-mean)
                             (repeat 1 (- phi 1.0))
                             (repeat 2 (- 2 phi))])]
            (y-mean-vec (random-int (dec (count y-mean-vec)))))
          x-sd 0
          y-sd 0
          start-angle (start-angle-vec (random-int (dec (count start-angle-vec)))) 
          end-angle (end-angle-vec (random-int (dec (count end-angle-vec)))) 
          vertex-sd
          (let [vertex-sd-vec [0 (pareto 0.01 0.1 0.1)]]
            (vertex-sd-vec (random-int (dec (count vertex-sd-vec)))))
          scale
          (let [vec [10 (pareto 5 20 1.16)]]
            (vec (random-int (dec (count vec)))))
          spiral-step
          (let [vec [0.005 (pareto 0.005 0.1 1.16)]]
            (vec (random-int (dec (count vec)))))
          s-weight (cond
                     (and (<= spiral-step 0.01) (<= vertex-sd 0.01)) 0.0005
                     (and (> spiral-step 0.01) (< spiral-step 0.05) (<= vertex-sd 0.01)) 0.001
                    :elseif  0.00005)]
      (let [col-ind (random-int (dec (count (s-col-vec palette-no))))]
        (apply q/stroke ((s-col-vec palette-no) col-ind) ))
      (q/stroke-weight (w s-weight))

      (comment
        (println (str "Params..."
                      "\nstart-angle = " start-angle
                      "\nend-angle = " end-angle
                      "\nx-mean = " x-mean
                      "\ny-mean = " y-mean
                      "\nx-sd = " x-sd
                      "\ny-sd = " y-sd
                      "\nvertex-sd = " vertex-sd
                      "\nnumber-vertices = " number-vertices
                      "\nscale = " scale
                      "\nno-iter = " no-iter
                      "\ns-weight = " s-weight)))

      (doseq [base (range 1.0 phi spiral-step)]
        (let [sp (gen-spiral-xy-vector base start-angle end-angle number-vertices)]
          (draw-spiral sp vertex-sd scale x-mean y-mean x-sd y-sd))))))




