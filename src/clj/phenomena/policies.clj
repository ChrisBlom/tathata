(ns phenomena.policies
  (:require phenomena.protocols
            [phenomena.impl.thread-pod :as tc]))

(defrecord SingleThreadedRWAccess [thread]
  phenomena.protocols/Sentry
  (make-pod [this val] (tc/->ThreadPod this val :phenomena.core/nothing))

  phenomena.protocols/Axiomatic
  (precept [_] (identical? (Thread/currentThread) thread))
  (precept-failure-msg [_] "You cannot access this pod across disparate threads."))


(defrecord ConstructOnly []
  phenomena.protocols/Sentry
  (make-pod [this val] (tc/->ThreadPod this val :phenomena.core/nothing))

  phenomena.protocols/Axiomatic
  (precept [_] false)
  (precept-failure-msg [_] "You cannot access this pod after construction."))